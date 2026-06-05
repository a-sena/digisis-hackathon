package no.digisis.hackathon.spor2.oppgave30;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
 * Oppgave 30 — Komponerte tjenester (15 poeng)
 *
 * Tynn kontroller som injiserer {@link BeregningService} via konstruktøren
 * og delegerer. GET /beregning/{fnr} svarer med andelen av G.
 */
@RestController
public class BeregningController {

    private final BeregningService service;

    public BeregningController(BeregningService service) {
        this.service = service;
    }

    @GetMapping("/beregning/{fnr}")
    public int beregn(@PathVariable String fnr) {
        // TODO: deleger til tjenesten og returner resultatet.
        throw new UnsupportedOperationException("Oppgave 30 — ikke implementert ennå");
    }
}
