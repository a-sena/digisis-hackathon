package no.digisis.hackathon.spor2.oppgave16;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import no.digisis.hackathon.spor2.domain.Fodselsnummer;
import no.digisis.hackathon.spor2.domain.ForeldrepengerSoknad;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SoknadSerializerTest {

    private static ForeldrepengerSoknad demoSak() {
        return new ForeldrepengerSoknad(
                Fodselsnummer.av("01059010006"),
                "Aisha", "Hassan", 34, "0560", 32_000);
    }

    @Test
    void testJsonInneholderFornavn() throws JsonProcessingException {
        String json = SoknadSerializer.tilJson(demoSak());
        JsonNode node = new ObjectMapper().readTree(json);
        assertEquals("Aisha", node.get("fornavn").asText());
    }

    @Test
    void testJsonInneholderAlder() throws JsonProcessingException {
        String json = SoknadSerializer.tilJson(demoSak());
        JsonNode node = new ObjectMapper().readTree(json);
        assertEquals(34, node.get("alder").asInt());
    }

    @Test
    void testJsonInneholderManedsinntekt() throws JsonProcessingException {
        String json = SoknadSerializer.tilJson(demoSak());
        JsonNode node = new ObjectMapper().readTree(json);
        assertEquals(32_000, node.get("manedsinntekt").asInt());
    }
}
