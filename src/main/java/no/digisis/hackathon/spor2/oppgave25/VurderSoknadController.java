package no.digisis.hackathon.spor2.oppgave25;

import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

/**
 * Ferdig kontroller — du skal IKKE endre denne. Den tar imot en
 * {@link VurderRequest} og svarer 200 {@code {"ok": true}} når valideringen
 * passerer. Jobben din ligger i {@link DekningsgradValidator}: en ugyldig
 * dekningsgrad skal få {@code @Valid} til å avvise requesten med 400.
 */
@RestController
public class VurderSoknadController {

    @PostMapping("/vurder-soknad")
    public Map<String, Boolean> vurder(@Valid @RequestBody VurderRequest request) {
        return Map.of("ok", true);
    }
}
