package no.digisis.hackathon.spor2.oppgave37;

import no.digisis.hackathon.spor2.oppgave35.Vedtak;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class RapporteringTest {

    private static final List<Vedtak> VEDTAK = List.of(
            new Vedtak.Innvilget(540_000),
            new Vedtak.Innvilget(780_960),
            new Vedtak.Innvilget(300_000),
            new Vedtak.Engangsstonad(),
            new Vedtak.Avslag(),
            new Vedtak.ManuellVurdering());

    @Test
    void testRapportTellerPerStatus() {
        Rapport r = Rapportering.lagRapport(VEDTAK);
        assertEquals(3, r.antallPerStatus().get("INNVILGET"));
        assertEquals(1, r.antallPerStatus().get("ENGANGSSTONAD"));
        assertEquals(1, r.antallPerStatus().get("AVSLAG"));
        assertEquals(1, r.antallPerStatus().get("MANUELL_VURDERING"));
    }

    @Test
    void testRapportSumOgSnitt() {
        Rapport r = Rapportering.lagRapport(VEDTAK);
        assertEquals(1_620_960L, r.totaltGrunnlag());        // 540000+780960+300000
        assertEquals(540_320L, r.snittGrunnlagInnvilget());  // 1620960 / 3
    }

    @Test
    void testRapportTomListe() {
        Rapport r = Rapportering.lagRapport(List.of());
        assertEquals(0L, r.totaltGrunnlag());
        assertEquals(0L, r.snittGrunnlagInnvilget());
        assertEquals(0, r.antallPerStatus().get("INNVILGET"));
        assertEquals(0, r.antallPerStatus().get("AVSLAG"));
    }

    @Test
    void testAlleFireStatuserMedSelvOmInnholdMangler() {
        // Bare avslag → de tre andre nøklene må fortsatt være med som 0.
        Rapport r = Rapportering.lagRapport(List.of(new Vedtak.Avslag(), new Vedtak.Avslag()));
        assertEquals(2, r.antallPerStatus().get("AVSLAG"));
        assertEquals(0, r.antallPerStatus().get("INNVILGET"));
        assertEquals(0, r.antallPerStatus().get("ENGANGSSTONAD"));
        assertEquals(0, r.antallPerStatus().get("MANUELL_VURDERING"));
    }

    @Test
    void testSnittAvrundesTilNaermesteHeltall() {
        // 100 + 101 = 201, snitt 100,5 → Math.round → 101.
        Rapport r = Rapportering.lagRapport(List.of(
                new Vedtak.Innvilget(100), new Vedtak.Innvilget(101)));
        assertEquals(201L, r.totaltGrunnlag());
        assertEquals(101L, r.snittGrunnlagInnvilget());
    }
}
