package no.digisis.hackathon.spor2.oppgave11;

import no.digisis.hackathon.spor2.domain.Inntektsregistrering;
import no.digisis.hackathon.spor2.domain.Inntektstype;
import no.digisis.hackathon.spor2.domain.Soknad;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;

class SumPerTypeTest {

    private static Soknad soknad(String id, Inntektsregistrering... historikk) {
        return new Soknad(
                id, "test", "04059012377", true, "2026-08-15",
                0, List.of(historikk), 1, "begge", 100);
    }

    private static Inntektsregistrering reg(String maned, Inntektstype type, int belop) {
        return new Inntektsregistrering(maned, type, belop);
    }

    @Test
    void testToSoknaderMedOverlappendeTyperSummeres() {
        var soknader = List.of(
                soknad("fp-1",
                        reg("2026-01", Inntektstype.ARBEID, 40_000),
                        reg("2026-02", Inntektstype.SYKEPENGER, 10_000)),
                soknad("fp-2",
                        reg("2026-01", Inntektstype.ARBEID, 35_000),
                        reg("2026-02", Inntektstype.ARBEID, 35_000))
        );
        Map<Inntektstype, Long> resultat = SumPerType.sumPerType(soknader);
        assertEquals(110_000L, resultat.get(Inntektstype.ARBEID));
        assertEquals(10_000L, resultat.get(Inntektstype.SYKEPENGER));
    }

    @Test
    void testEnTypeSummeres() {
        var soknader = List.of(
                soknad("fp-1",
                        reg("2026-01", Inntektstype.DAGPENGER, 20_000),
                        reg("2026-02", Inntektstype.DAGPENGER, 25_000))
        );
        var resultat = SumPerType.sumPerType(soknader);
        assertEquals(1, resultat.size());
        assertEquals(45_000L, resultat.get(Inntektstype.DAGPENGER));
    }

    @Test
    void testTomListeGirTomMap() {
        var resultat = SumPerType.sumPerType(List.of());
        assertEquals(0, resultat.size());
    }

    @Test
    void testTypeSomForekommerEnGang() {
        var soknader = List.of(
                soknad("fp-1",
                        reg("2026-01", Inntektstype.ARBEID, 40_000),
                        reg("2026-02", Inntektstype.AAP, 18_000))
        );
        var resultat = SumPerType.sumPerType(soknader);
        assertEquals(18_000L, resultat.get(Inntektstype.AAP));
        assertFalse(resultat.containsKey(Inntektstype.SYKEPENGER));
    }
}
