package no.digisis.hackathon.spor2.oppgave41;

/**
 * Oppgave 41 — Kvote-allokering for foreldrepenger (30 poeng — avansert)
 *
 * <p>Fordel ukene i stønadsperioden mellom mor, far/medmor, fellesperiode
 * og flerbarnsdager-bonus.
 *
 * <p>Reglene (forenklet for hackathonen — vi behandler "1 dag" som
 * ekstra uke der det er relevant, og 3+ barn som "3+"):
 *
 * <h3>For dekning 100% (begge har rett):</h3>
 * <ul>
 *   <li>morKvote = 18 uker (15 etter fødsel + 3 før termin)</li>
 *   <li>farKvote = 15 uker</li>
 *   <li>fellesKvote = 16 uker</li>
 * </ul>
 *
 * <h3>For dekning 80% (begge har rett):</h3>
 * <ul>
 *   <li>morKvote = 22 uker (19 + 3 før termin)</li>
 *   <li>farKvote = 19 uker</li>
 *   <li>fellesKvote = 20 uker</li>
 * </ul>
 *
 * <h3>Når kun mor har rett:</h3> alle ukene går til mor; far = 0, felles = 0.
 * <h3>Når kun far har rett:</h3> alle ukene går til far; mor = 0, felles = 0.
 * Total ved kun-far er forkortet (40 uker @ 100%, 52 @ 80%).
 *
 * <h3>Flerbarnsdager-bonus (gjelder uansett rettsforhold):</h3>
 * <table>
 *   <tr><th>antall barn</th><th>100%</th><th>80%</th></tr>
 *   <tr><td>1</td><td>0</td><td>0</td></tr>
 *   <tr><td>2</td><td>17</td><td>21</td></tr>
 *   <tr><td>3+</td><td>46</td><td>57</td></tr>
 * </table>
 *
 * <p>Validering: {@code antallBarn} må være ≥ 1; {@code dekning} må være 100 eller 80.
 * Ugyldig input → {@link IllegalArgumentException}.
 */
public final class Kvote {

    private Kvote() {}

    public static Kvoter fordel(Rettsforhold rettsforhold, int antallBarn, int dekning) {
        // TODO
        throw new UnsupportedOperationException("Oppgave 41 — ikke implementert ennå");
    }

    public record Kvoter(int morKvote, int farKvote, int fellesKvote, int flerbarnsdagerBonus) {
        public int totalt() {
            return morKvote + farKvote + fellesKvote + flerbarnsdagerBonus;
        }
    }

    public enum Rettsforhold { BEGGE, KUN_MOR, KUN_FAR }
}
