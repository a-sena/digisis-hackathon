package no.digisis.hackathon.spor2.oppgave23;

import no.digisis.hackathon.spor2.oppgave12.SoknadsRegister;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

/**
 * Oppgave 23 — Status, headers og ResponseEntity (15 poeng)
 *
 * GET /antall-soknader skal svare med:
 *   • status 200 OK,
 *   • en respons-header {@code X-Total-Count} satt til antallet (som streng),
 *   • en JSON-kropp {@code {"antall": <n>}}.
 *
 * Dette viser hvordan {@link ResponseEntity} lar deg styre status, headere
 * og body samtidig.
 */
@RestController
public class AntallController {

    private final SoknadsRegister register;

    public AntallController(SoknadsRegister register) {
        this.register = register;
    }

    @GetMapping("/antall-soknader")
    public ResponseEntity<Map<String, Integer>> antall() {
        // TODO: bygg en ResponseEntity med 200, X-Total-Count-header og body {"antall": n}.
        throw new UnsupportedOperationException("Oppgave 23 — ikke implementert ennå");
    }
}
