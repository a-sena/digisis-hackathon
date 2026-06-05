package no.digisis.hackathon.spor2.oppgave25;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Egendefinert Bean Validation-constraint. Et felt merket med
 * {@code @GyldigDekningsgrad} er gyldig kun når verdien er 80 eller 100.
 *
 * <p>Selve regelen ligger i {@link DekningsgradValidator} — det er den
 * du skal implementere.
 */
@Constraint(validatedBy = DekningsgradValidator.class)
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
public @interface GyldigDekningsgrad {
    String message() default "dekningsgrad må være 80 eller 100";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
