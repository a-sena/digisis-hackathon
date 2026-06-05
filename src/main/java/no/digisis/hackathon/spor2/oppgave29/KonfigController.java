package no.digisis.hackathon.spor2.oppgave29;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Oppgave 29 — Konfigurasjon og properties (15 poeng)
 *
 * Grunnbeløpet (G) endres årlig og bør derfor være konfigurerbart, ikke
 * hardkodet. {@code @Value} leser verdien fra en property med en fornuftig
 * default ({@code dds.grunnbelop}, default 118620) — feltet er allerede
 * satt opp for deg.
 *
 * Implementer {@link #grunnbelop()}: returner den injiserte verdien.
 * En test setter property-en via {@code @SpringBootTest(properties=...)}
 * for å bekrefte at den overstyrer defaulten.
 */
@RestController
public class KonfigController {

    @Value("${dds.grunnbelop:118620}")
    int grunnbelop;

    @GetMapping("/konfig/grunnbelop")
    public int grunnbelop() {
        // TODO: returner den konfigurerte verdien.
        throw new UnsupportedOperationException("Oppgave 29 — ikke implementert ennå");
    }
}
