package no.digisis.hackathon.spor2.oppgave37;

import java.util.Map;

/**
 * Aggregert rapport over en liste vedtak.
 *
 * @param antallPerStatus        antall vedtak per status — <b>alle fire</b>
 *                               statuser med ("INNVILGET", "ENGANGSSTONAD",
 *                               "AVSLAG", "MANUELL_VURDERING"), 0 når ingen
 * @param totaltGrunnlag         sum av grunnlag for INNVILGET-vedtak
 * @param snittGrunnlagInnvilget snitt-grunnlag for INNVILGET (heltall,
 *                               avrundet), 0 når ingen er innvilget
 */
public record Rapport(
        Map<String, Integer> antallPerStatus,
        long totaltGrunnlag,
        long snittGrunnlagInnvilget
) {}
