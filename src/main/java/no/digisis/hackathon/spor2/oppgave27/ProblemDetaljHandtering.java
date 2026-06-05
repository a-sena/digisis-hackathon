package no.digisis.hackathon.spor2.oppgave27;

import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * Oppgave 27 — ProblemDetail (RFC 7807) (15 poeng)
 *
 * Legg til en {@code @ExceptionHandler(VedtakIkkeFunnet.class)} her som
 * oversetter {@link VedtakIkkeFunnet} til en {@code ProblemDetail} med
 * status <b>404 Not Found</b>.
 *
 * <p>Tips:
 * <pre>{@code
 *   ProblemDetail pd = ProblemDetail.forStatusAndDetail(HttpStatus.NOT_FOUND, e.getMessage());
 *   pd.setTitle("Vedtak ikke funnet");
 *   return pd;
 * }</pre>
 * Returtypen er {@code ProblemDetail} — Spring setter status og
 * {@code application/problem+json} for deg.
 *
 * <p>NB: håndter KUN {@link VedtakIkkeFunnet} her — ikke en bred
 * {@code Exception} — så denne adviceen ikke påvirker andre oppgaver.
 */
@RestControllerAdvice
public class ProblemDetaljHandtering {

    // TODO: @ExceptionHandler(VedtakIkkeFunnet.class) → ProblemDetail med 404 + title
}
