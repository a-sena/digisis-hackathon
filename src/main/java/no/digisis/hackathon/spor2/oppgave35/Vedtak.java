package no.digisis.hackathon.spor2.oppgave35;

/**
 * Utfallet av en foreldrepenger-vurdering — en sum-type (sealed) med
 * fire varianter. Bruk pattern matching (`switch`) på et `Vedtak` for å
 * håndtere alle fire uten å glemme noen.
 */
public sealed interface Vedtak
        permits Vedtak.Innvilget, Vedtak.Engangsstonad, Vedtak.Avslag, Vedtak.ManuellVurdering {

    /** Innvilget foreldrepenger med beregnet grunnlag (kappet ved 6G). */
    record Innvilget(int grunnlag) implements Vedtak {}

    /** Opptjening feilet, men søker er medlem → engangsstønad. */
    record Engangsstonad() implements Vedtak {}

    /** Verken foreldrepenger eller engangsstønad (ikke medlem). */
    record Avslag() implements Vedtak {}

    /** For stort avvik mot oppgitt inntekt — må vurderes manuelt. */
    record ManuellVurdering() implements Vedtak {}
}
