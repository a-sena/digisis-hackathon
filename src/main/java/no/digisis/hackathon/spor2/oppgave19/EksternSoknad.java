package no.digisis.hackathon.spor2.oppgave19;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Ekstern representasjon med direktoratets egne feltnavn. Jackson bruker
 * {@link JsonProperty} til å gi hvert felt riktig JSON-nøkkel.
 *
 * <p>Ferdig definert — du skal fylle den og serialisere den i
 * {@link SoknadJsonWriter#tilJson}.
 */
public record EksternSoknad(
        @JsonProperty("foedselsnummer") String foedselsnummer,
        @JsonProperty("navn") String navn,
        @JsonProperty("postnr") String postnr,
        @JsonProperty("inntekt") int inntekt) {}
