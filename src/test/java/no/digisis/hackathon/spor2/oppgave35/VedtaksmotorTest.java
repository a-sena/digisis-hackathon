package no.digisis.hackathon.spor2.oppgave35;

import no.digisis.hackathon.spor2.domain.Inntektsregistrering;
import no.digisis.hackathon.spor2.domain.Inntektstype;
import no.digisis.hackathon.spor2.domain.Soknad;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertInstanceOf;

class VedtaksmotorTest {

    /** Søknad med `maneder` like inntektsmåneder à `belop` kroner. */
    private static Soknad soknad(boolean norsk, int maneder, int belop, Inntektstype type, int oppgitt) {
        List<Inntektsregistrering> hist = new ArrayList<>();
        for (int i = 1; i <= maneder; i++) {
            hist.add(new Inntektsregistrering(String.format("2026-%02d", i), type, belop));
        }
        return new Soknad("fp-test", "test", "04059012377", norsk, "2026-08-15",
                oppgitt, hist, 1, "begge", 100);
    }

    @Test
    void testHappyPathGirInnvilgetMedGrunnlag() {
        // 10 mnd à 45 000 → annualisert 540 000 ≥ ½G; snitt siste 3 = 45 000
        // → årssats 540 000; oppgitt 540 000 (avvik 0); under 6G.
        Vedtak v = Vedtaksmotor.vurder(soknad(true, 10, 45_000, Inntektstype.ARBEID, 540_000));
        assertEquals(new Vedtak.Innvilget(540_000), v);
    }

    @Test
    void testIkkeNorskGirAvslag() {
        Vedtak v = Vedtaksmotor.vurder(soknad(false, 10, 50_000, Inntektstype.ARBEID, 600_000));
        assertInstanceOf(Vedtak.Avslag.class, v);
    }

    @Test
    void testForFaManederGirEngangsstonad() {
        Vedtak v = Vedtaksmotor.vurder(soknad(true, 4, 50_000, Inntektstype.ARBEID, 0));
        assertInstanceOf(Vedtak.Engangsstonad.class, v);
    }

    @Test
    void testUnderHalvGGirEngangsstonad() {
        // 6 mnd à 5 000 → sum 30 000 → annualisert 36 000 < 65 080.
        Vedtak v = Vedtaksmotor.vurder(soknad(true, 6, 5_000, Inntektstype.ARBEID, 0));
        assertInstanceOf(Vedtak.Engangsstonad.class, v);
    }

    @Test
    void testStipendTellerIkkeGirEngangsstonad() {
        // 10 mnd, men alle er stipend → 0 godkjente måneder.
        Vedtak v = Vedtaksmotor.vurder(soknad(true, 10, 60_000, Inntektstype.STIPEND_LANEKASSEN, 0));
        assertInstanceOf(Vedtak.Engangsstonad.class, v);
    }

    @Test
    void testStortAvvikGirManuellVurdering() {
        // årssats 540 000 vs oppgitt 300 000 → avvik 0,8 > 0,25.
        Vedtak v = Vedtaksmotor.vurder(soknad(true, 10, 45_000, Inntektstype.ARBEID, 300_000));
        assertInstanceOf(Vedtak.ManuellVurdering.class, v);
    }

    @Test
    void testOppgittNullHopperOverAvvik() {
        Vedtak v = Vedtaksmotor.vurder(soknad(true, 10, 45_000, Inntektstype.ARBEID, 0));
        assertEquals(new Vedtak.Innvilget(540_000), v);
    }

    @Test
    void testArssatsOver6GKappes() {
        // 10 mnd à 100 000 → årssats 1 200 000 → kappes til 780 960.
        Vedtak v = Vedtaksmotor.vurder(soknad(true, 10, 100_000, Inntektstype.ARBEID, 1_200_000));
        assertEquals(new Vedtak.Innvilget(Vedtaksmotor.SEKS_G), v);
    }

    @Test
    void testGrensetilfelleAnnualisertOverHalvGGirInnvilget() {
        // 6 mnd à 10 847 → sum 65 082 → annualisert 78 098,4 ≥ ½G; opptjening holder.
        Vedtak v = Vedtaksmotor.vurder(soknad(true, 6, 10_847, Inntektstype.ARBEID, 0));
        assertInstanceOf(Vedtak.Innvilget.class, v);
        assertEquals(65_080, Vedtaksmotor.HALV_G);
    }
}
