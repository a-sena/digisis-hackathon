package no.digisis.hackathon.spor2.oppgave07;

import no.digisis.hackathon.spor2.domain.Soknad;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class NdjsonLeserTest {

    private static String soknad(String id) {
        return "{"
                + "\"id\":\"" + id + "\","
                + "\"beskrivelse\":\"test\","
                + "\"fnr\":\"01059010006\","
                + "\"erNorskBorger\":true,"
                + "\"termindato\":\"2026-01-15\","
                + "\"oppgittArsinntekt\":600000,"
                + "\"inntektshistorikk\":[{\"maned\":\"2025-10\",\"type\":\"ARBEID\",\"belop\":50000}],"
                + "\"antallBarn\":1,"
                + "\"rettsforhold\":\"begge\","
                + "\"dekningsgrad\":100"
                + "}";
    }

    @Test
    void test3GyldigeLinjerGir3Soknader() {
        String tekst = soknad("fp-001") + "\n" + soknad("fp-002") + "\n" + soknad("fp-003");
        List<Soknad> soknader = NdjsonLeser.les(tekst);
        assertEquals(3, soknader.size());
        assertEquals(List.of("fp-001", "fp-002", "fp-003"),
                soknader.stream().map(Soknad::id).toList());
    }

    @Test
    void testRattenLinjeIMidtenHoppesOver() {
        String tekst = soknad("fp-001") + "\n"
                + "{ dette er ikke gyldig json\n"
                + soknad("fp-003");
        List<Soknad> soknader = NdjsonLeser.les(tekst);
        assertEquals(2, soknader.size());
        assertEquals(List.of("fp-001", "fp-003"),
                soknader.stream().map(Soknad::id).toList());
    }

    @Test
    void testBlankeLinjerHoppesOver() {
        String tekst = soknad("fp-001") + "\n\n   \n" + soknad("fp-002") + "\n";
        List<Soknad> soknader = NdjsonLeser.les(tekst);
        assertEquals(2, soknader.size());
    }

    @Test
    void testAltUgyldigGirTomListe() {
        String tekst = "ikke json\n{ enda mer ugyldig\n}}}";
        List<Soknad> soknader = NdjsonLeser.les(tekst);
        assertTrue(soknader.isEmpty());
    }
}
