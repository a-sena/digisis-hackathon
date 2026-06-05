package no.digisis.hackathon.spor2.oppgave02;

import java.util.List;

/**
 * Oppgave 2 — Beregningsgrunnlag for foreldrepenger (20 poeng)
 *
 * NAV regner ut beregningsgrunnlaget slik:
 *
 *   1. Snitt av <strong>siste 3 måneders inntekt</strong>, oppjustert
 *      til årssats (× 12).
 *   2. Hvis snitt-årssatsen avviker mer enn <strong>25%</strong> fra
 *      søkers oppgitte årsinntekt, skal saken vurderes manuelt
 *      (NAV bestemmer hva som er mest representativt).
 *   3. Ellers brukes snitt-årssatsen som grunnlag, men <strong>kappet
 *      ved 6G</strong> (seks ganger grunnbeløpet).
 *
 * Du får {@code grunnbeloep} som parameter — slå opp dagens verdi via
 * <a href="https://g.nav.no/api/v1/grunnbeloep">g.nav.no</a> i
 * applikasjonen, og send den inn her. Tester sender en kjent verdi.
 *
 * Variansreglen: |snitt-årssats - aarsinntekt| / aarsinntekt &gt; 0.25.
 * Hvis {@code aarsinntekt} er 0, hopp over varianssjekken (det er
 * Opptjening sin jobb å avvise null-inntekt).
 */
public final class Beregning {

    private Beregning() {}

    public static Resultat beregn(List<Integer> sisteTreManeder, int aarsinntekt, int grunnbeloep) {
        // TODO
        if (sisteTreManeder == null || sisteTreManeder.isEmpty()) {
            return new Resultat.Grunnlag(0);
        }
        // Snitt av <strong>siste 3 måneders inntekt</strong>, oppjustert
        // *      til årssats (× 12).
            int sumTreManeder = 0;
            for (int mndBeloep : sisteTreManeder) {
            sumTreManeder += mndBeloep;
        }
            int snittAarsats = sumTreManeder * 4;
    //Hvis snitt-årssatsen avviker mer enn <strong>25%</strong> fra
        // *      søkers oppgitte årsinntekt, skal saken vurderes manuelt
        // *      (NAV bestemmer hva som er mest representativt).
        if (aarsinntekt > 0) {
            int avvik = Math.abs(snittAarsats - aarsinntekt);
        if (avvik > (aarsinntekt * 0.25)) {
            return new Resultat.ManuellVurdering("Mer enn 25% avvik.");
        }
    }
       // Ellers brukes snitt-årssatsen som grunnlag, men <strong>kappet ved 6G</strong> (seks ganger grunnbeløpet)
        int maksGrunnlag = 6 * grunnbeloep;
        int endeligBeloep = snittAarsats;
        if (endeligBeloep > maksGrunnlag) {
            endeligBeloep = maksGrunnlag;
        }

        return new Resultat.Grunnlag(endeligBeloep);
    }
    public sealed interface Resultat permits Resultat.Grunnlag, Resultat.ManuellVurdering {
        record Grunnlag(int beloep) implements Resultat {}
        record ManuellVurdering(String grunn) implements Resultat {}
    }
}
