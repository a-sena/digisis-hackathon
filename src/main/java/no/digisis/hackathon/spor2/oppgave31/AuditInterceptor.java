package no.digisis.hackathon.spor2.oppgave31;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.web.servlet.HandlerInterceptor;

import java.util.List;

/**
 * Oppgave 31 — Middleware / interceptor: revisjonsspor (20 poeng)
 *
 * En {@link HandlerInterceptor} kjører rundt hver request — som Hono sin
 * {@code app.use(...)}. Her skal du føre ett revisjonsspor: for hver
 * request som er ferdigbehandlet, legg en {@link Auditpost} i {@code logg}.
 *
 * <p>Implementer {@code afterCompletion}: legg til
 * {@code new Auditpost(request.getMethod(), request.getRequestURI(),
 * response.getStatus())}. Slik samles tverrgående logikk ett sted i
 * stedet for i hver kontroller.
 */
public class AuditInterceptor implements HandlerInterceptor {

    private final List<Auditpost> logg;

    public AuditInterceptor(List<Auditpost> logg) {
        this.logg = logg;
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response,
                                Object handler, Exception ex) {
        // TODO: legg en Auditpost i logg (metode, URI, status)
    }
}
