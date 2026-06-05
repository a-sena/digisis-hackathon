package no.digisis.hackathon.spor2.oppgave37;

import no.digisis.hackathon.spor2.oppgave35.Vedtak;

import java.util.List;

/**
 * Oppgave 37 — Aggregert vedtaksrapport (20 poeng)
 *
 * <p>Gå gjennom en liste med {@link Vedtak} (fra vedtaksmotoren, oppgave
 * 35) og bygg en {@link Rapport}:
 *
 * <ul>
 *   <li>antall per status — alle fire med, 0 når ingen.</li>
 *   <li>totaltGrunnlag — sum av {@code grunnlag} for alle INNVILGET.</li>
 *   <li>snittGrunnlagInnvilget — snitt for INNVILGET, avrundet til
 *       nærmeste heltall ({@code Math.round}), 0 når ingen er innvilget.</li>
 * </ul>
 *
 * <p>Tips: bruk pattern matching i en {@code switch} på {@code Vedtak}
 * for å hente status-navnet og grunnlaget på en uttømmende måte.
 */
public final class Rapportering {

    private Rapportering() {}

    public static Rapport lagRapport(List<Vedtak> vedtak) {
        // TODO
        throw new UnsupportedOperationException("Oppgave 37 — ikke implementert ennå");
    }
}
