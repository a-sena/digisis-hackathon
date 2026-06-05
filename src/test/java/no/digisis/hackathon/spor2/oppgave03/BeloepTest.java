package no.digisis.hackathon.spor2.oppgave03;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class BeloepTest {

    @Test
    void testAvBeholderKroner() {
        assertEquals(100, Beloep.av(100).kroner());
    }

    @Test
    void testAvNegativKaster() {
        assertThrows(IllegalArgumentException.class, () -> Beloep.av(-1));
    }

    @Test
    void testPlussLeggerSammen() {
        assertEquals(Beloep.av(150), Beloep.av(100).pluss(Beloep.av(50)));
    }

    @Test
    void testProsentAv() {
        assertEquals(Beloep.av(50), Beloep.av(200).prosentAv(25));
    }

    @Test
    void testKappOverTakGirTak() {
        assertEquals(Beloep.av(800), Beloep.av(1000).kapp(Beloep.av(800)));
    }

    @Test
    void testKappUnderTakBeholderBeloep() {
        assertEquals(Beloep.av(500), Beloep.av(500).kapp(Beloep.av(800)));
    }
}
