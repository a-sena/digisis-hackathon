package no.digisis.hackathon.spor2.oppgave17;

import com.fasterxml.jackson.core.JsonProcessingException;

import no.digisis.hackathon.spor2.domain.Inntektstype;
import no.digisis.hackathon.spor2.domain.Soknad;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

class SoknadDeserializerTest {

    private static final String GYLDIG_JSON = """
        {"id":"fp-1","beskrivelse":"happy path","fnr":"04059012377",
         "erNorskBorger":true,"termindato":"2026-08-15","oppgittArsinntekt":540000,
         "inntektshistorikk":[
           {"maned":"2025-11","type":"ARBEID","belop":45000},
           {"maned":"2025-12","type":"ARBEID","belop":45000}],
         "antallBarn":1,"rettsforhold":"begge","dekningsgrad":100}
        """;

    @Test
    void testParserGyldigJson() throws JsonProcessingException {
        Soknad soknad = SoknadDeserializer.fraJson(GYLDIG_JSON);
        assertEquals("fp-1", soknad.id());
        assertEquals("04059012377", soknad.fnr());
        assertTrue(soknad.erNorskBorger());
        assertEquals(100, soknad.dekningsgrad());
        assertEquals(2, soknad.inntektshistorikk().size());
    }

    @Test
    void testIgnorererUkjentFelt() throws JsonProcessingException {
        String medEkstra = """
            {"id":"fp-2","beskrivelse":"t","fnr":"13057812360","erNorskBorger":true,
             "termindato":"2026-08-15","oppgittArsinntekt":540000,
             "inntektshistorikk":[],"antallBarn":1,"rettsforhold":"begge",
             "dekningsgrad":80,"saksbehandlerNotat":"dette feltet finnes ikke i modellen"}
            """;
        Soknad soknad = SoknadDeserializer.fraJson(medEkstra);
        assertEquals("fp-2", soknad.id());
        assertEquals(80, soknad.dekningsgrad());
    }

    @Test
    void testParserNostetInntektshistorikk() throws JsonProcessingException {
        Soknad soknad = SoknadDeserializer.fraJson(GYLDIG_JSON);
        var forste = soknad.inntektshistorikk().get(0);
        assertEquals("2025-11", forste.maned());
        assertEquals(Inntektstype.ARBEID, forste.type());
        assertEquals(45_000, forste.belop());
    }

    @Test
    void testManglendeValgfrittFeltBlirNull() throws JsonProcessingException {
        // beskrivelse mangler helt — deserialiseringen skal ikke feile.
        String utenBeskrivelse = """
            {"id":"fp-3","fnr":"04059012377","erNorskBorger":true,
             "termindato":"2026-08-15","oppgittArsinntekt":0,
             "inntektshistorikk":[],"antallBarn":1,"rettsforhold":"kun-mor",
             "dekningsgrad":100}
            """;
        Soknad soknad = SoknadDeserializer.fraJson(utenBeskrivelse);
        assertEquals("fp-3", soknad.id());
        assertNull(soknad.beskrivelse());
    }
}
