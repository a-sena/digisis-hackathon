package no.digisis.hackathon.spor2.oppgave40;

import no.digisis.hackathon.spor2.oppgave40.Utbetalingsplan.Utbetalingslinje;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class UtbetalingsplanTest {

    @Test
    void testUkesatsFraGrunnlag() {
        // floor(540000/260)=2076, ×5 = 10 380
        List<Utbetalingslinje> plan = Utbetalingsplan.lagUtbetalingsplan(540_000, LocalDate.parse("2026-08-15"), 3);
        assertEquals(3, plan.size());
        assertEquals(10_380, plan.get(0).ukesats());
    }

    @Test
    void testDatoeneLoperUkeForUke() {
        List<Utbetalingslinje> plan = Utbetalingsplan.lagUtbetalingsplan(540_000, LocalDate.parse("2026-08-15"), 3);
        assertEquals(new Utbetalingslinje(1, LocalDate.parse("2026-08-15"), LocalDate.parse("2026-08-21"), 10_380), plan.get(0));
        assertEquals(new Utbetalingslinje(2, LocalDate.parse("2026-08-22"), LocalDate.parse("2026-08-28"), 10_380), plan.get(1));
        // krysser månedsskiftet aug→sep
        assertEquals(new Utbetalingslinje(3, LocalDate.parse("2026-08-29"), LocalDate.parse("2026-09-04"), 10_380), plan.get(2));
    }

    @Test
    void testAntallUkerNullGirTomPlan() {
        assertEquals(List.of(), Utbetalingsplan.lagUtbetalingsplan(540_000, LocalDate.parse("2026-08-15"), 0));
    }

    @Test
    void testDagsatsBrukerHeltallsdivisjon() {
        // floor(100000/260)=384 (ikke 384,6…), ×5 = 1 920
        List<Utbetalingslinje> plan = Utbetalingsplan.lagUtbetalingsplan(100_000, LocalDate.parse("2026-08-15"), 1);
        assertEquals(1, plan.size());
        assertEquals(1_920, plan.get(0).ukesats());
    }

    @Test
    void testEnUkeGirEnLinje() {
        List<Utbetalingslinje> plan = Utbetalingsplan.lagUtbetalingsplan(540_000, LocalDate.parse("2026-08-15"), 1);
        assertEquals(List.of(
                new Utbetalingslinje(1, LocalDate.parse("2026-08-15"), LocalDate.parse("2026-08-21"), 10_380)), plan);
    }
}
