package no.digisis.hackathon.spor2.oppgave02;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertInstanceOf;

class BeregningTest {

    /** G i 2025. */
    private static final int G = 130_160;

    @Test
    void testStabilInntektGirGrunnlag() {
        // 3 × 50 000 → snitt 50 000 → årssats 600 000
        var resultat = Beregning.beregn(List.of(50_000, 50_000, 50_000), 600_000, G);
        var grunnlag = assertInstanceOf(Beregning.Resultat.Grunnlag.class, resultat);
        assertEquals(600_000, grunnlag.beloep());
    }

    @Test
    void testHoyVarianceGirManuellVurdering() {
        // snitt 80 000 → årssats 960 000; oppgitt 600 000 → diff 60% > 25%
        var resultat = Beregning.beregn(List.of(80_000, 80_000, 80_000), 600_000, G);
        assertInstanceOf(Beregning.Resultat.ManuellVurdering.class, resultat);
    }

    @Test
    void testGrunnlagKappesTil6G() {
        // 3 × 100 000 → årssats 1 200 000; oppgitt også 1 200 000 (ingen variance)
        var resultat = Beregning.beregn(List.of(100_000, 100_000, 100_000), 1_200_000, G);
        var grunnlag = assertInstanceOf(Beregning.Resultat.Grunnlag.class, resultat);
        assertEquals(6 * G, grunnlag.beloep());
    }

    @Test
    void testLavVarianseUnderTerskelGirGrunnlag() {
        // snitt 55 000 → årssats 660 000; oppgitt 600 000 → diff 10% < 25%
        var resultat = Beregning.beregn(List.of(55_000, 55_000, 55_000), 600_000, G);
        var grunnlag = assertInstanceOf(Beregning.Resultat.Grunnlag.class, resultat);
        assertEquals(660_000, grunnlag.beloep());
    }

    @Test
    void testEksaktTerskelGirGrunnlag() {
        // snitt 62 500 → årssats 750 000; oppgitt 600 000 → diff 25% (ikke > 25%)
        var resultat = Beregning.beregn(List.of(62_500, 62_500, 62_500), 600_000, G);
        assertInstanceOf(Beregning.Resultat.Grunnlag.class, resultat);
    }

    @Test
    void testNullAarsinntektHopperOverVariance() {
        var resultat = Beregning.beregn(List.of(50_000, 50_000, 50_000), 0, G);
        var grunnlag = assertInstanceOf(Beregning.Resultat.Grunnlag.class, resultat);
        assertEquals(600_000, grunnlag.beloep());
    }

    @Test
    void testUlikeMaanederSnittes() {
        // 30 000 + 50 000 + 70 000 = 150 000; snitt 50 000 → årssats 600 000
        var resultat = Beregning.beregn(List.of(30_000, 50_000, 70_000), 600_000, G);
        var grunnlag = assertInstanceOf(Beregning.Resultat.Grunnlag.class, resultat);
        assertEquals(600_000, grunnlag.beloep());
    }
}
