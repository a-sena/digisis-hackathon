package no.digisis.hackathon.spor2.oppgave38;

import no.digisis.hackathon.spor2.domain.Inntektsregistrering;
import no.digisis.hackathon.spor2.domain.Inntektstype;
import no.digisis.hackathon.spor2.domain.Soknad;
import no.digisis.hackathon.spor2.oppgave38.Saksflyt.Saksflytresultat;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class SaksflytTest {

    /** Søknad med `maneder` like inntektsmåneder à `belop`; `id` for sporing. */
    private static Soknad soknad(String id, boolean norsk, int maneder, int belop, int oppgitt) {
        List<Inntektsregistrering> hist = new ArrayList<>();
        for (int i = 1; i <= maneder; i++) {
            hist.add(new Inntektsregistrering(String.format("2026-%02d", i), Inntektstype.ARBEID, belop));
        }
        return new Soknad(id, "test", "04059012377", norsk, "2026-08-15",
                oppgitt, hist, 1, "begge", 100);
    }

    // Hver fabrikk treffer ett utfall fra vedtaksmotoren (oppgave 35):
    private static Soknad innvilgetSoknad(String id) {
        return soknad(id, true, 10, 45_000, 0);          // → Innvilget(540 000)
    }

    private static Soknad engangsstonadSoknad(String id) {
        return soknad(id, true, 4, 50_000, 0);           // for få mnd → Engangsstonad
    }

    private static Soknad avslagSoknad(String id) {
        return soknad(id, false, 10, 50_000, 600_000);   // ikke norsk → Avslag
    }

    private static Soknad manuellSoknad(String id) {
        return soknad(id, true, 10, 45_000, 300_000);    // stort avvik → ManuellVurdering
    }

    @Test
    void testEnAvHverHavnerIRiktigBotte() {
        var res = Saksflyt.kjor(List.of(
                innvilgetSoknad("i1"),
                engangsstonadSoknad("e1"),
                avslagSoknad("a1"),
                manuellSoknad("m1")));
        assertEquals(List.of("i1"), res.innvilget().stream().map(Soknad::id).toList());
        assertEquals(List.of("e1"), res.engangsstonad().stream().map(Soknad::id).toList());
        assertEquals(List.of("a1"), res.avslag().stream().map(Soknad::id).toList());
        assertEquals(List.of("m1"), res.manuell().stream().map(Soknad::id).toList());
    }

    @Test
    void testTomListeGirAlleTomme() {
        Saksflytresultat res = Saksflyt.kjor(List.of());
        assertTrue(res.innvilget().isEmpty());
        assertTrue(res.engangsstonad().isEmpty());
        assertTrue(res.avslag().isEmpty());
        assertTrue(res.manuell().isEmpty());
    }

    @Test
    void testInnvilgetSoknadLanderIInnvilget() {
        Soknad s = innvilgetSoknad("i1");
        Saksflytresultat res = Saksflyt.kjor(List.of(s));
        assertEquals(List.of(s), res.innvilget());
        assertTrue(res.engangsstonad().isEmpty());
    }

    @Test
    void testAntallSummererTilInput() {
        var input = List.of(
                innvilgetSoknad("i1"), innvilgetSoknad("i2"),
                engangsstonadSoknad("e1"),
                avslagSoknad("a1"),
                manuellSoknad("m1"), manuellSoknad("m2"));
        Saksflytresultat res = Saksflyt.kjor(input);
        int sum = res.innvilget().size() + res.engangsstonad().size()
                + res.avslag().size() + res.manuell().size();
        assertEquals(input.size(), sum);
    }

    @Test
    void testRekkefolgeBevaresInnenBotte() {
        var res = Saksflyt.kjor(List.of(
                innvilgetSoknad("i1"),
                innvilgetSoknad("i2"),
                avslagSoknad("a1"),
                innvilgetSoknad("i3")));
        assertEquals(List.of("i1", "i2", "i3"),
                res.innvilget().stream().map(Soknad::id).toList());
    }
}
