package no.digisis.hackathon.spor2.oppgave10;

import no.digisis.hackathon.spor2.domain.Fodselsnummer;
import no.digisis.hackathon.spor2.domain.ForeldrepengerSoknad;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class PartisjoneringTest {

    private static ForeldrepengerSoknad soknad(int alder, int lonn) {
        return new ForeldrepengerSoknad(
                Fodselsnummer.av("01059010006"),
                "Test", "Person", alder, "0560", lonn);
    }

    @Test
    void testBlandetGirRiktigeTellereOgSummer() {
        var soknader = List.of(
                soknad(30, 25_000),  // berettiget
                soknad(40, 30_000),  // berettiget
                soknad(50, 40_000),  // ikke (inntekt for høy)
                soknad(70, 20_000)   // ikke (for gammel)
        );
        var p = Partisjonering.oppsummer(soknader);
        assertEquals(2L, p.antallBerettiget());
        assertEquals(2L, p.antallIkke());
        assertEquals(55_000L, p.sumBerettiget());
        assertEquals(60_000L, p.sumIkke());
    }

    @Test
    void testAlleBerettiget() {
        var soknader = List.of(
                soknad(18, 10_000),
                soknad(67, 34_999)
        );
        var p = Partisjonering.oppsummer(soknader);
        assertEquals(2L, p.antallBerettiget());
        assertEquals(0L, p.antallIkke());
        assertEquals(44_999L, p.sumBerettiget());
        assertEquals(0L, p.sumIkke());
    }

    @Test
    void testIngenBerettiget() {
        var soknader = List.of(
                soknad(17, 10_000),  // for ung
                soknad(45, 35_000)   // inntekt ikke under grensen
        );
        var p = Partisjonering.oppsummer(soknader);
        assertEquals(0L, p.antallBerettiget());
        assertEquals(2L, p.antallIkke());
        assertEquals(0L, p.sumBerettiget());
        assertEquals(45_000L, p.sumIkke());
    }

    @Test
    void testTomListeGirNull() {
        var p = Partisjonering.oppsummer(List.of());
        assertEquals(0L, p.antallBerettiget());
        assertEquals(0L, p.antallIkke());
        assertEquals(0L, p.sumBerettiget());
        assertEquals(0L, p.sumIkke());
    }
}
