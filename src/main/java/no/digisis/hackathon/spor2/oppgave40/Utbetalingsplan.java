package no.digisis.hackathon.spor2.oppgave40;

import java.time.LocalDate;
import java.util.List;

/**
 * Oppgave 40 — Utbetalingsplan (15 poeng)
 *
 * <p>Bygg en datert utbetalingsplan, én linje per uke:
 * <pre>
 *   dagsats = grunnlag / 260   (heltallsdivisjon; 260 stønadsdager i året)
 *   ukesats = dagsats * 5      (5 stønadsdager per uke)
 * </pre>
 * Linje {@code i} (1-indeksert) dekker {@code [startDato + (i-1)*7,  + 6 dager]}.
 * {@code antallUker = 0} gir en tom liste.
 */
public final class Utbetalingsplan {

    private Utbetalingsplan() {}

    public record Utbetalingslinje(int uke, LocalDate fraDato, LocalDate tilDato, int ukesats) {}

    public static List<Utbetalingslinje> lagUtbetalingsplan(int grunnlag, LocalDate startDato, int antallUker) {
        // TODO
        throw new UnsupportedOperationException("Oppgave 40 — ikke implementert ennå");
    }
}
