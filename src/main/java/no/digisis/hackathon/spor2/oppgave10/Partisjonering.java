package no.digisis.hackathon.spor2.oppgave10;

import no.digisis.hackathon.spor2.domain.ForeldrepengerSoknad;

import java.util.List;

/**
 * Oppgave 10 — Partisjonering & oppsummering (15 poeng)
 *
 * Del soknadene i to bøtter — <i>berettiget</i> og <i>ikke berettiget</i> —
 * og tell antall og sum av månedsinntekt i hver bøtte i én operasjon.
 *
 * <p>En soknad er <b>berettiget</b> når BEGGE holder:
 * <ul>
 *   <li>alder i intervallet [18, 67] (inklusive begge ender)</li>
 *   <li>månedsinntekt &lt; 35 000</li>
 * </ul>
 *
 * Bruk {@link java.util.stream.Collectors#partitioningBy} med en
 * downstream-collector som teller og summerer ({@code summingInt} +
 * {@code counting}). Tom liste skal gi 0 på alle fire feltene.
 */
public final class Partisjonering {

    public record Partisjon(long antallBerettiget, long antallIkke, long sumBerettiget, long sumIkke) {}

    private Partisjonering() {}

    public static Partisjon oppsummer(List<ForeldrepengerSoknad> soknader) {
        // TODO: partisjoner på berettiget-regelen, og for hver bøtte
        //       regn ut (antall, sum månedsinntekt).
        throw new UnsupportedOperationException("Oppgave 10 — ikke implementert ennå");
    }
}
