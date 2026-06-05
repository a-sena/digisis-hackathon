package no.digisis.hackathon.spor2.oppgave01;

import java.util.List;

/**
 * Oppgave 1 — Opptjeningskrav for foreldrepenger (20 poeng)
 *
 * Søker har rett til foreldrepenger når begge vilkår er oppfylt:
 *
 *   1. Inntekt fra <strong>godkjent type</strong> i minst 6 av de siste
 *      10 månedene.
 *   2. Sum godkjent inntekt i perioden er minst <strong>½G</strong>
 *      (halve grunnbeløpet — du får verdien som parameter).
 *
 * Godkjente inntektstyper: ARBEID, SYKEPENGER, DAGPENGER, AAP,
 * FORELDREPENGER, SVANGERSKAPSPENGER, PLEIEPENGER.
 *
 * Ikke-godkjente: FERIEPENGER, LANEKASSEN. (Feriepenger er en
 * forsinket utbetaling, og lån/stipend regnes ikke som inntekt.)
 *
 * Detaljer:
 *   - "Måned med inntekt" = minst én godkjent registrering den måneden.
 *     Flere registreringer i samme måned teller som én måned.
 *   - Tom historikk → false.
 *   - {@code halvG} er ½G i kroner (slå opp via g.nav.no, eller
 *     bruk det som blir injisert i tester).
 */
public final class Opptjening {

    private Opptjening() {}

    public static boolean harOpptjening(List<Inntektsregistrering> historikk, int halvG) {
        // TODO
        throw new UnsupportedOperationException("Oppgave 1 — ikke implementert ennå");
    }

    public record Inntektsregistrering(String maaned, InntektsType type, int beloep) {}

    public enum InntektsType {
        ARBEID,
        SYKEPENGER,
        DAGPENGER,
        AAP,
        FORELDREPENGER,
        SVANGERSKAPSPENGER,
        PLEIEPENGER,
        FERIEPENGER,
        LANEKASSEN
    }
}
