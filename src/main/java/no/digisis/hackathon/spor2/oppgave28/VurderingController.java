package no.digisis.hackathon.spor2.oppgave28;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
 * Oppgave 28 — Tjenestelag og dependency injection (15 poeng)
 *
 * Kontrolleren skal være tynn: den injiserer {@link VurderingService} via
 * konstruktøren og delegerer alt arbeid dit. GET /vurdering/{fnr} svarer
 * med resultatet fra tjenesten.
 */
@RestController
public class VurderingController {

    private final VurderingService service;

    public VurderingController(VurderingService service) {
        this.service = service;
    }

    @GetMapping("/vurdering/{fnr}")
    public String vurder(@PathVariable String fnr) {
        // TODO: deleger til tjenesten og returner resultatet.
        throw new UnsupportedOperationException("Oppgave 28 — ikke implementert ennå");
    }
}
