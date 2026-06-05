package no.digisis.hackathon.spor2.oppgave17;

import com.fasterxml.jackson.core.JsonProcessingException;

import no.digisis.hackathon.spor2.domain.Soknad;

/**
 * Oppgave 17 — Deserialiser JSON → domene (15 poeng)
 *
 * Motsatt vei av oppgave 16: gjør om en JSON-streng til en {@link Soknad}
 * (den «rike» API-modellen med inntektshistorikk). Bruk Jackson sin
 * {@code ObjectMapper}.
 *
 * <p><b>Viktig:</b> JSON-en kan inneholde ekstra felter du ikke bryr deg
 * om (API-er vokser over tid). Deserialiseringen skal IKKE feile på
 * ukjente felter — konfigurer mapperen til å ignorere dem
 * ({@code DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES = false}).
 *
 * <p>Den nøstede {@code inntektshistorikk}-listen skal parses i samme
 * kall — Jackson håndterer nøstede records automatisk.
 */
public final class SoknadDeserializer {

    private SoknadDeserializer() {}

    public static Soknad fraJson(String json) throws JsonProcessingException {
        // TODO
        throw new UnsupportedOperationException("Oppgave 17 — ikke implementert ennå");
    }
}
