package no.digisis.hackathon.spor2.oppgave19;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import no.digisis.hackathon.spor2.domain.Fodselsnummer;
import no.digisis.hackathon.spor2.domain.ForeldrepengerSoknad;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class SoknadJsonWriterTest {

    private static ForeldrepengerSoknad aisha() {
        return new ForeldrepengerSoknad(
                Fodselsnummer.av("01059011234"), "Aisha", "Hassan", 34, "0560", 32_000);
    }

    private static JsonNode parse(ForeldrepengerSoknad soknad) throws JsonProcessingException {
        return new ObjectMapper().readTree(SoknadJsonWriter.tilJson(soknad));
    }

    @Test
    void testHarCustomNokler() throws JsonProcessingException {
        JsonNode node = parse(aisha());
        assertTrue(node.has("foedselsnummer"));
        assertTrue(node.has("navn"));
        assertTrue(node.has("postnr"));
        assertTrue(node.has("inntekt"));
        assertEquals("0560", node.get("postnr").asText());
        assertEquals(32_000, node.get("inntekt").asInt());
    }

    @Test
    void testFoedselsnummerMaskert() throws JsonProcessingException {
        assertEquals("*******1234", parse(aisha()).get("foedselsnummer").asText());
    }

    @Test
    void testNavnSlasSammen() throws JsonProcessingException {
        assertEquals("Aisha Hassan", parse(aisha()).get("navn").asText());
    }

    @Test
    void testIngenDomenenokler() throws JsonProcessingException {
        JsonNode node = parse(aisha());
        assertFalse(node.has("fornavn"));
        assertFalse(node.has("etternavn"));
        assertFalse(node.has("fnr"));
    }
}
