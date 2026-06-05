// Parse target/surefire-reports/, find tasks where ALL tests are green,
// fetch a GitHub OIDC token, and POST results to the leaderboard.
//
// Designed to never fail the workflow — exit 0 on every outcome the
// participant cannot fix (network errors, unknown repo, etc.).

import {readdir, readFile} from 'node:fs/promises';
import {join} from 'node:path';

const LEADERBOARD_URL = 'https://leaderboard.digisis.org';
const AUDIENCE = LEADERBOARD_URL;
const REPORTS_DIR = 'target/surefire-reports';

// Class-name overrides — for tests that don't follow the `oppgaveNN`
// package convention. (Empty for now; all tests are in oppgaveNN packages.)
const TASK_OVERRIDES = {};

const args = parseArgs();
const track = Number.parseInt(args.track ?? '0', 10);
if (!Number.isFinite(track) || track < 1) {
  console.error('Missing or invalid --track');
  process.exit(0);
}

const completed = await collectGreenTasks();
if (completed.size === 0) {
  console.log('No tasks fully passed yet — nothing to submit.');
  process.exit(0);
}

const tasks = [...completed].sort((a, b) => a - b);
console.log(`Tasks fully green this run: ${tasks.join(', ')}`);

const oidcToken = await getOidcToken();
if (!oidcToken) {
  console.log('No OIDC token available — skipping submit.');
  process.exit(0);
}

const res = await fetch(`${LEADERBOARD_URL}/api/submit`, {
  method: 'POST',
  headers: {
    'content-type': 'application/json',
    authorization: `Bearer ${oidcToken}`,
  },
  body: JSON.stringify({ track, tasks }),
});
const body = await res.text();
console.log(`Leaderboard responded: HTTP ${res.status} ${body}`);
process.exit(0);

// ─────────────────────────────────────────────────────────────────────

async function collectGreenTasks() {
  let entries;
  try {
    entries = await readdir(REPORTS_DIR);
  } catch {
    console.log(`No ${REPORTS_DIR} directory — did mvn test run?`);
    return new Set();
  }

  const xmlFiles = entries.filter(
    (f) => f.startsWith('TEST-') && f.endsWith('.xml'),
  );

  const completed = new Set();
  for (const file of xmlFiles) {
    const xml = await readFile(join(REPORTS_DIR, file), 'utf8');
    const fullClass = file.slice(5, -4); // strip "TEST-" and ".xml"
    const taskNum = taskFromClassName(fullClass);
    if (taskNum === null) continue;

    const counts = readCounts(xml);
    if (counts === null) continue;

    const allGreen =
      counts.tests > 0 &&
      counts.failures === 0 &&
      counts.errors === 0 &&
      counts.skipped === 0;
    if (allGreen) {
      completed.add(taskNum);
    }
  }
  return completed;
}

function taskFromClassName(fullClass) {
  // First try `oppgaveNN` in the package path.
  const m = fullClass.match(/\.oppgave(\d+)\./);
  if (m) return Number.parseInt(m[1], 10);

  // Fall back to overrides keyed on the simple class name.
  const simpleName = fullClass.split('.').pop() ?? '';
  return TASK_OVERRIDES[simpleName] ?? null;
}

function readCounts(xml) {
  const open = xml.match(/<testsuite\b[^>]*>/);
  if (!open) return null;
  const tag = open[0];
  return {
    tests: intAttr(tag, 'tests'),
    failures: intAttr(tag, 'failures'),
    errors: intAttr(tag, 'errors'),
    skipped: intAttr(tag, 'skipped'),
  };
}

function intAttr(tag, name) {
  const m = tag.match(new RegExp(`\\b${name}="(\\d+)"`));
  return m ? Number.parseInt(m[1], 10) : 0;
}

async function getOidcToken() {
  const requestToken = process.env.ACTIONS_ID_TOKEN_REQUEST_TOKEN;
  const requestUrl = process.env.ACTIONS_ID_TOKEN_REQUEST_URL;
  if (!requestToken || !requestUrl) {
    console.error(
      'Missing ACTIONS_ID_TOKEN_REQUEST_* env. Make sure permissions: id-token: write is set in the workflow.',
    );
    return null;
  }
  const url = `${requestUrl}&audience=${encodeURIComponent(AUDIENCE)}`;
  const res = await fetch(url, {
    headers: { authorization: `bearer ${requestToken}` },
  });
  if (!res.ok) {
    console.error(`OIDC token request failed: HTTP ${res.status}`);
    return null;
  }
  const json = await res.json();
  return json.value;
}

function parseArgs() {
  const out = {};
  const argv = process.argv.slice(2);
  for (let i = 0; i < argv.length; i++) {
    const arg = argv[i];
    if (arg.startsWith('--')) {
      out[arg.slice(2)] = argv[++i];
    }
  }
  return out;
}
