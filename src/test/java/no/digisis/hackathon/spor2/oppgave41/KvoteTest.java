package no.digisis.hackathon.spor2.oppgave41;

import org.junit.jupiter.api.Test;

import static no.digisis.hackathon.spor2.oppgave41.Kvote.Rettsforhold.*;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class KvoteTest {

    @Test
    void testBegge1Barn100Prosent() {
        var k = Kvote.fordel(BEGGE, 1, 100);
        assertEquals(18, k.morKvote());
        assertEquals(15, k.farKvote());
        assertEquals(16, k.fellesKvote());
        assertEquals(0, k.flerbarnsdagerBonus());
        assertEquals(49, k.totalt());
    }

    @Test
    void testBegge2Barn100Prosent() {
        var k = Kvote.fordel(BEGGE, 2, 100);
        assertEquals(18, k.morKvote());
        assertEquals(15, k.farKvote());
        assertEquals(16, k.fellesKvote());
        assertEquals(17, k.flerbarnsdagerBonus());
        assertEquals(66, k.totalt());
    }

    @Test
    void testBegge3Barn100Prosent() {
        var k = Kvote.fordel(BEGGE, 3, 100);
        assertEquals(46, k.flerbarnsdagerBonus());
        assertEquals(95, k.totalt());
    }

    @Test
    void testBegge4Barn100ProsentBrukerSammeSomTreEllerFlere() {
        var k = Kvote.fordel(BEGGE, 4, 100);
        assertEquals(46, k.flerbarnsdagerBonus());
    }

    @Test
    void testBegge1Barn80Prosent() {
        var k = Kvote.fordel(BEGGE, 1, 80);
        assertEquals(22, k.morKvote());
        assertEquals(19, k.farKvote());
        assertEquals(20, k.fellesKvote());
        assertEquals(0, k.flerbarnsdagerBonus());
        assertEquals(61, k.totalt());
    }

    @Test
    void testKunMor1Barn100Prosent() {
        var k = Kvote.fordel(KUN_MOR, 1, 100);
        assertEquals(49, k.morKvote());
        assertEquals(0, k.farKvote());
        assertEquals(0, k.fellesKvote());
        assertEquals(0, k.flerbarnsdagerBonus());
        assertEquals(49, k.totalt());
    }

    @Test
    void testKunMor2Barn100ProsentFaarBonus() {
        var k = Kvote.fordel(KUN_MOR, 2, 100);
        assertEquals(49, k.morKvote());
        assertEquals(17, k.flerbarnsdagerBonus());
        assertEquals(66, k.totalt());
    }

    @Test
    void testKunFar1Barn100Prosent() {
        var k = Kvote.fordel(KUN_FAR, 1, 100);
        assertEquals(0, k.morKvote());
        assertEquals(40, k.farKvote());
        assertEquals(0, k.fellesKvote());
        assertEquals(0, k.flerbarnsdagerBonus());
        assertEquals(40, k.totalt());
    }

    @Test
    void testKunFar3Barn80Prosent() {
        var k = Kvote.fordel(KUN_FAR, 3, 80);
        assertEquals(52, k.farKvote());
        assertEquals(57, k.flerbarnsdagerBonus());
        assertEquals(109, k.totalt());
    }

    @Test
    void testUgyldigAntallBarnKaster() {
        assertThrows(IllegalArgumentException.class, () -> Kvote.fordel(BEGGE, 0, 100));
    }

    @Test
    void testUgyldigDekningKaster() {
        assertThrows(IllegalArgumentException.class, () -> Kvote.fordel(BEGGE, 1, 90));
    }
}
