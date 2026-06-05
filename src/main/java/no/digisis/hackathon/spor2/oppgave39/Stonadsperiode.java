package no.digisis.hackathon.spor2.oppgave39;

/**
 * Oppgave 39 — Stønadsperiode-oppslag (15 poeng)
 *
 * <p>Slå opp totalt antall uker i stønadsperioden ut fra rettsforhold,
 * antall barn og dekningsgrad. Grunnperiode + flerbarns-tillegg
 * (forenklet, samme tall som kvote-oppgaven):
 * <pre>
 *   Grunnperiode:
 *     "begge":               100 % → 49,  80 % → 61
 *     "kun-mor"/"kun-far":   100 % → 40,  80 % → 52
 *   Flerbarns-tillegg (uker, uansett rettsforhold):
 *     1 barn → 0
 *     2 barn → 100 %: 17,  80 %: 21
 *     3+ barn → 100 %: 46, 80 %: 57
 * </pre>
 * Totalt = grunnperiode + tillegg.
 */
public final class Stonadsperiode {

    private Stonadsperiode() {}

    public static int stonadsperiodeUker(String rettsforhold, int antallBarn, int dekningsgrad) {
        // TODO
        throw new UnsupportedOperationException("Oppgave 39 — ikke implementert ennå");
    }
}
