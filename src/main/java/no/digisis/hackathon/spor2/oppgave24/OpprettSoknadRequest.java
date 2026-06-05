package no.digisis.hackathon.spor2.oppgave24;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;

/**
 * Inn-DTO for opprettelse av soknad. Vi tar imot fnr som streng og
 * lar Bean Validation gjøre format-sjekk (lengde 11 sifre). Ekte
 * fnr-validering (om nummeret finnes) gjøres mot api.digisis.org/api/fnr
 * — aldri som en lokal Mod-11-beregning.
 */
public record OpprettSoknadRequest(
        @NotBlank
        @Pattern(regexp = "\\d{11}", message = "fnr må være 11 sifre")
        String fnr,

        @NotBlank
        String fornavn,

        @NotBlank
        String etternavn,

        @Min(value = 0, message = "alder må være ≥ 0")
        int alder,

        @Pattern(regexp = "\\d{4}", message = "postnummer må være 4 sifre")
        String postnummer,

        @Min(value = 0, message = "manedsinntekt må være ≥ 0")
        int manedsinntekt
) {}
