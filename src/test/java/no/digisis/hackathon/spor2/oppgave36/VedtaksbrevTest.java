package no.digisis.hackathon.spor2.oppgave36;

import no.digisis.hackathon.spor2.oppgave35.Vedtak;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class VedtaksbrevTest {

    @Test
    void testInnvilgetGirGrunnlagSetning() {
        assertEquals(
                "Søknaden er innvilget med et grunnlag på 540000 kr.",
                Vedtaksbrev.brev(new Vedtak.Innvilget(540_000)));
    }

    @Test
    void testEngangsstonadGirSetning() {
        assertEquals("Du får engangsstønad.", Vedtaksbrev.brev(new Vedtak.Engangsstonad()));
    }

    @Test
    void testAvslagGirSetning() {
        assertEquals("Søknaden er avslått.", Vedtaksbrev.brev(new Vedtak.Avslag()));
    }

    @Test
    void testManuellVurderingGirSetning() {
        assertEquals("Saken går til manuell vurdering.", Vedtaksbrev.brev(new Vedtak.ManuellVurdering()));
    }

    @Test
    void testInnvilgetBrevInneholderGrunnlaget() {
        String brev = Vedtaksbrev.brev(new Vedtak.Innvilget(123_456));
        assertTrue(brev.contains("123456"), "brevet skal inneholde grunnlaget");
    }
}
