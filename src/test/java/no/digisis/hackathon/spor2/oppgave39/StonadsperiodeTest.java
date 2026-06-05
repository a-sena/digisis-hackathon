package no.digisis.hackathon.spor2.oppgave39;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class StonadsperiodeTest {

    @Test
    void testBegge1Barn100() {
        assertEquals(49, Stonadsperiode.stonadsperiodeUker("begge", 1, 100));
    }

    @Test
    void testBegge2Barn100() {
        assertEquals(66, Stonadsperiode.stonadsperiodeUker("begge", 2, 100)); // 49 + 17
    }

    @Test
    void testBegge3Barn80() {
        assertEquals(118, Stonadsperiode.stonadsperiodeUker("begge", 3, 80)); // 61 + 57
    }

    @Test
    void testKunMor1Barn100() {
        assertEquals(40, Stonadsperiode.stonadsperiodeUker("kun-mor", 1, 100));
    }

    @Test
    void testKunFar1Barn80() {
        assertEquals(52, Stonadsperiode.stonadsperiodeUker("kun-far", 1, 80));
    }
}
