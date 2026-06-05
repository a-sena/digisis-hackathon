package no.digisis.hackathon.spor2.oppgave25;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

/**
 * Oppgave 25 — Egendefinert validator (15 poeng)
 *
 * Implementer {@link #isValid} slik at en dekningsgrad er gyldig kun når
 * verdien er <b>80</b> eller <b>100</b>. Alt annet (inkludert null) skal
 * gi {@code false} → 400 Bad Request når DTO-en valideres.
 */
public class DekningsgradValidator implements ConstraintValidator<GyldigDekningsgrad, Integer> {

    @Override
    public boolean isValid(Integer value, ConstraintValidatorContext context) {
        // TODO: returner true kun for 80 eller 100.
        throw new UnsupportedOperationException("Oppgave 25 — ikke implementert ennå");
    }
}
