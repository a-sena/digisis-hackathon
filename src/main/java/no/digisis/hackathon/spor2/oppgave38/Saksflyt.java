package no.digisis.hackathon.spor2.oppgave38;

import no.digisis.hackathon.spor2.domain.Soknad;

import java.util.List;

/**
 * Oppgave 38 — Batch-saksflyt (20 poeng)
 *
 * <p>Kjør vedtaksmotoren (oppgave 35) på en hel bunke søknader og
 * partisjonér <b>søknadene</b> etter hvilken {@code Vedtak}-variant de
 * endte i. Resultatet er en {@link Saksflytresultat} med én liste per
 * utfall.
 *
 * <p>Krav:
 * <ul>
 *   <li>Hver {@link Soknad} kjøres gjennom
 *       {@code no.digisis.hackathon.spor2.oppgave35.Vedtaksmotor#vurder}.</li>
 *   <li>Søknaden (ikke vedtaket) legges i bøtta som svarer til variantens
 *       utfall: Innvilget → {@code innvilget}, Engangsstonad →
 *       {@code engangsstonad}, Avslag → {@code avslag}, ManuellVurdering →
 *       {@code manuell}.</li>
 *   <li>Rekkefølgen innen hver bøtte følger inn-rekkefølgen.</li>
 * </ul>
 */
public final class Saksflyt {

    private Saksflyt() {}

    public record Saksflytresultat(
            List<Soknad> innvilget,
            List<Soknad> engangsstonad,
            List<Soknad> avslag,
            List<Soknad> manuell
    ) {}

    public static Saksflytresultat kjor(List<Soknad> soknader) {
        // TODO
        throw new UnsupportedOperationException("Oppgave 38 — ikke implementert ennå");
    }
}
