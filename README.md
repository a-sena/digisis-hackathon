# Spor 2 — Viderekommen - Java

**Tema:** Foreldrepenger-saksbehandling hos Direktoratet for Digital Saksbehandling (DDS).

I dette sporet bygger du opp et saksbehandlingssystem for foreldrepenger-søknader bit for bit.
Du kaller en ekstern API for fnr-validering, implementerer foreldrepenger-regler fra NAV,
og åpner det hele opp som et REST-API på slutten.

## Slik kommer du i gang

1. **JDK 26** og **Maven** må være installert.
2. Åpne prosjektet i IntelliJ IDEA.
3. Kjør `mvn test` i terminalen og sjekk at alle testene er rødt (siden ingen oppgaver er løst enda).
4. Start med oppgave 1 (`oppgave01.Opptjening`), bytt ut `TODO`-kroppen med din egen løsning, og kjør testen `oppgave01.OpptjeningTest` igjen til den blir grønn. Husk at du må fjerne `throws`-koden.
5. Gjenta for oppgave 2, 3, 4, osv. Vanskeligheten stiger jevnt gjennom tolv nivåer.

Hver oppgavemappe har en egen `HELP.md` med korte hint hvis du står fast.

## Oppgaver

Stigende vanskelighet, gruppert i tolv nivåer. Hvert nivå lærer ett nytt
verktøy fra backend-verktøykassa — Stream/Collectors, REST, JSON,
validering, feilhåndtering, avhengighetsinjeksjon, konfigurasjon,
middleware, robust HTTP og regelmotor.

### Nivå 1 — Domenemodellering og regler

| # | Oppgave | Poeng |
|---|---|---|
| 1 | Opptjeningskrav-sjekk (6 av 10 mnd + ½G) | 20 |
| 2 | Beregningsgrunnlag (snitt × 12, 6G-cap, varianssjekk) | 20 |
| 3 | Pengebeløp som verdiobjekt | 15 |
| 4 | Saksstatus-tilstandsmaskin (sealed + pattern matching) | 20 |

### Nivå 2 — Innlesing og robust parsing

| # | Oppgave | Poeng |
|---|---|---|
| 5 | Les søknader fra CSV | 15 |
| 6 | Robust parsing med feilsamling | 20 |
| 7 | Les NDJSON (tolerant) | 15 |

### Nivå 3 — Datatransformasjon (Stream/Collectors)

| # | Oppgave | Poeng |
|---|---|---|
| 8 | Statistikk per inntektskategori | 15 |
| 9 | Topp-3 inntekt per postnummer | 15 |
| 10 | Partisjonering og oppsummering | 15 |
| 11 | Flat-map og aggregering | 20 |

### Nivå 4 — Datastrukturer og registre

| # | Oppgave | Poeng |
|---|---|---|
| 12 | In-memory søknadsregister | 20 |
| 13 | Generisk register | 20 |
| 14 | Trådsikkert register | 20 |
| 15 | Prioritert saksbehandlingskø | 20 |

### Nivå 5 — JSON og DTO-mapping

| # | Oppgave | Poeng |
|---|---|---|
| 16 | Serialiser til JSON manuelt | 15 |
| 17 | Deserialiser JSON til domene | 15 |
| 18 | DTO-mapping (skjul intern fnr) | 15 |
| 19 | Custom feltnavn og format | 15 |

### Nivå 6 — REST-grunnlag

| # | Oppgave | Poeng |
|---|---|---|
| 20 | GET /soknader | 15 |
| 21 | GET /soknader/{fnr} (200/404) | 15 |
| 22 | GET /soknader/filter | 15 |
| 23 | Status, headers og ResponseEntity | 15 |

### Nivå 7 — Validering og feilhåndtering

| # | Oppgave | Poeng |
|---|---|---|
| 24 | POST /soknader med Bean Validation | 20 |
| 25 | Egendefinert validator | 15 |
| 26 | Sentralisert feilhåndtering (`@RestControllerAdvice`) | 20 |
| 27 | ProblemDetail (problem+json) | 15 |

### Nivå 8 — Tjenestelag, DI og konfigurasjon

| # | Oppgave | Poeng |
|---|---|---|
| 28 | Tjenestelag og avhengighetsinjeksjon (`@Service`) | 20 |
| 29 | Konfigurasjon og properties (`@Value`) | 15 |
| 30 | Komponerte tjenester | 20 |
| 31 | Middleware/interceptor (revisjonsspor) | 20 |

### Nivå 9 — Utgående HTTP og robusthet

| # | Oppgave | Poeng |
|---|---|---|
| 32 | Hent og valider søknader fra API (parallell) | 20 |
| 33 | Robust HTTP-klient: timeout og fallback | 20 |
| 34 | Retry med backoff | 20 |

### Nivå 10 — Regelmotor og vedtak

| # | Oppgave | Poeng |
|---|---|---|
| 35 | Vedtaksmotor (regelmotor → `Vedtak` sum-type) | 30 |
| 36 | Vedtaksbrev (pattern-matching) | 15 |
| 37 | Aggregert vedtaksrapport | 20 |
| 38 | Batch-saksflyt | 20 |

### Nivå 11 — Stønad og kvote

| # | Oppgave | Poeng |
|---|---|---|
| 39 | Stønadsperiode-oppslag | 15 |
| 40 | Utbetalingsplan (datert) | 20 |
| 41 | Kvote-allokering (mor / far / felles + flerbarnsdager) | 30 |

### Nivå 12 — Forvaltning og drift

| # | Oppgave | Poeng |
|---|---|---|
| 42 | CRUD for saksnotater | 20 |
| 43 | Paginering og sortering | 15 |
| 44 | Idempotent oppdatering og audit | 15 |

**Sum:** 795 poeng over 44 oppgaver.

## Eksterne avhengigheter

- **g.nav.no** — gir dagens grunnbeløp; brukes som parameter til oppgave 2.
- **api.digisis.org/api/fnr** — fnr-validering over HTTP; kalles fra oppgave 5 (CSV-innlesing).

## Leaderboard

Hver gang du **pusher kode**, kjører GitHub Actions testene dine og
oppdaterer poengene dine på [leaderboard.digisis.org](https://leaderboard.digisis.org)
(1–3 minutter forsinkelse). En oppgave teller når **alle testene** for
den er grønne — delvise resultater gir 0 poeng.

## Spring Boot-oppgavene (REST: nivå 6–8)

Start appen lokalt:

```
mvn spring-boot:run
```

Test fra terminalen:

```
curl http://localhost:8080/soknader
curl http://localhost:8080/soknader/01059010006
curl "http://localhost:8080/soknader/filter?minInntekt=30000"
```

## Spilleregler

- Det er lov å spørre. Det er forventet å spørre.
- Det er lov å samarbeide og hjelpe sidemannen.
- Hopp over en oppgave hvis den henger seg fast — kom tilbake til den senere.

Lykke til!
