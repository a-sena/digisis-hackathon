package no.digisis.hackathon.spor2.oppgave26;

import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * Oppgave 26 — Sentralisert feilhåndtering (20 poeng)
 *
 * Legg til en {@code @ExceptionHandler(SakIkkeFunnet.class)} her som
 * oversetter {@link SakIkkeFunnet} til <b>404 Not Found</b> med kroppen
 * {@code {"feil": "<melding>"}}. Da slipper kontrollerne å returnere
 * statuskoder selv — feilhåndteringen bor ett sted.
 *
 * <p>Tips: returner en {@code ResponseEntity.status(404).body(...)} med
 * et lite {@code Map<String,String>}, eller en egen record.
 *
 * <p>NB: håndter KUN {@link SakIkkeFunnet} her — ikke en bred
 * {@code Exception} — så denne adviceen ikke påvirker andre oppgaver.
 */
@RestControllerAdvice
public class FeilHandtering {

    // TODO: @ExceptionHandler(SakIkkeFunnet.class) → 404 {"feil": e.getMessage()}
}
