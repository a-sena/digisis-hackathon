package no.digisis.hackathon.spor2.oppgave01;

import org.junit.jupiter.api.Test;

import java.util.List;

import static no.digisis.hackathon.spor2.oppgave01.Opptjening.InntektsType.*;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class OpptjeningTest {

    /** ½G i 2025 = 65 080 kr. */
    private static final int HALV_G = 65_080;

    private static Opptjening.Inntektsregistrering r(String maaned, Opptjening.InntektsType type, int beloep) {
        return new Opptjening.Inntektsregistrering(maaned, type, beloep);
    }

    @Test
    void test6MaanederArbeidGirOpptjening() {
        var historikk = List.of(
                r("2025-01", ARBEID, 30_000),
                r("2025-02", ARBEID, 30_000),
                r("2025-03", ARBEID, 30_000),
                r("2025-04", ARBEID, 30_000),
                r("2025-05", ARBEID, 30_000),
                r("2025-06", ARBEID, 30_000)
        );
        assertTrue(Opptjening.harOpptjening(historikk, HALV_G));
    }

    @Test
    void test5MaanederErForFa() {
        var historikk = List.of(
                r("2025-01", ARBEID, 30_000),
                r("2025-02", ARBEID, 30_000),
                r("2025-03", ARBEID, 30_000),
                r("2025-04", ARBEID, 30_000),
                r("2025-05", ARBEID, 30_000)
        );
        assertFalse(Opptjening.harOpptjening(historikk, HALV_G));
    }

    @Test
    void testFeriepengerTellerIkke() {
        var historikk = List.of(
                r("2025-01", FERIEPENGER, 30_000),
                r("2025-02", FERIEPENGER, 30_000),
                r("2025-03", FERIEPENGER, 30_000),
                r("2025-04", FERIEPENGER, 30_000),
                r("2025-05", FERIEPENGER, 30_000),
                r("2025-06", FERIEPENGER, 30_000)
        );
        assertFalse(Opptjening.harOpptjening(historikk, HALV_G));
    }

    @Test
    void testLanekassenTellerIkke() {
        var historikk = List.of(
                r("2025-01", LANEKASSEN, 12_000),
                r("2025-02", LANEKASSEN, 12_000),
                r("2025-03", LANEKASSEN, 12_000),
                r("2025-04", LANEKASSEN, 12_000),
                r("2025-05", LANEKASSEN, 12_000),
                r("2025-06", LANEKASSEN, 12_000)
        );
        assertFalse(Opptjening.harOpptjening(historikk, HALV_G));
    }

    @Test
    void testForLavSumGirIkkeOpptjening() {
        // 6 måneder, men hver bare 1 000 → sum = 6 000 < ½G
        var historikk = List.of(
                r("2025-01", ARBEID, 1_000),
                r("2025-02", ARBEID, 1_000),
                r("2025-03", ARBEID, 1_000),
                r("2025-04", ARBEID, 1_000),
                r("2025-05", ARBEID, 1_000),
                r("2025-06", ARBEID, 1_000)
        );
        assertFalse(Opptjening.harOpptjening(historikk, HALV_G));
    }

    @Test
    void testBlandetGodkjentTypeTeller() {
        var historikk = List.of(
                r("2025-01", ARBEID, 20_000),
                r("2025-02", SYKEPENGER, 18_000),
                r("2025-03", DAGPENGER, 12_000),
                r("2025-04", AAP, 14_000),
                r("2025-05", PLEIEPENGER, 5_000),
                r("2025-06", SVANGERSKAPSPENGER, 16_000)
        );
        assertTrue(Opptjening.harOpptjening(historikk, HALV_G));
    }

    @Test
    void testFlereRegistreringerSammeMaanedTellerSomEn() {
        // 6 registreringer, men bare 3 distinkte måneder → ikke nok
        var historikk = List.of(
                r("2025-01", ARBEID, 30_000),
                r("2025-01", SYKEPENGER, 5_000),
                r("2025-02", ARBEID, 30_000),
                r("2025-02", DAGPENGER, 5_000),
                r("2025-03", ARBEID, 30_000),
                r("2025-03", PLEIEPENGER, 5_000)
        );
        assertFalse(Opptjening.harOpptjening(historikk, HALV_G));
    }

    @Test
    void testFeriepengerIBlandetMaanedTellesIkke() {
        // 5 godkjente måneder + 1 feriepenger-måned → ikke 6 godkjente
        var historikk = List.of(
                r("2025-01", ARBEID, 30_000),
                r("2025-02", ARBEID, 30_000),
                r("2025-03", ARBEID, 30_000),
                r("2025-04", ARBEID, 30_000),
                r("2025-05", ARBEID, 30_000),
                r("2025-06", FERIEPENGER, 30_000)
        );
        assertFalse(Opptjening.harOpptjening(historikk, HALV_G));
    }

    @Test
    void testTomHistorikk() {
        assertFalse(Opptjening.harOpptjening(List.of(), HALV_G));
    }
}
