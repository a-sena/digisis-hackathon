package no.digisis.hackathon.spor2.oppgave25;

import jakarta.validation.constraints.Pattern;

/**
 * Inn-DTO for /vurder-soknad. {@code fnr} valideres med standard
 * Bean Validation (11 sifre), mens {@code dekningsgrad} valideres av den
 * egendefinerte {@link GyldigDekningsgrad}-constrainten.
 */
public record VurderRequest(
        @Pattern(regexp = "\\d{11}", message = "fnr må være 11 sifre")
        String fnr,

        @GyldigDekningsgrad
        int dekningsgrad
) {}
