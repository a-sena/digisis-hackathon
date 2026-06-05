package no.digisis.hackathon.spor2.domain;

/**
 * Inntektstype fra a-ordningen. Alt unntatt {@code STIPEND_LANEKASSEN}
 * regnes som godkjent inntekt for opptjening (§ 14-6).
 */
public enum Inntektstype {
    ARBEID,
    SYKEPENGER,
    FORELDREPENGER,
    SVANGERSKAPSPENGER,
    DAGPENGER,
    AAP,
    PLEIEPENGER,
    STIPEND_LANEKASSEN
}
