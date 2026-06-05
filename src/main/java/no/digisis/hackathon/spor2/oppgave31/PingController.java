package no.digisis.hackathon.spor2.oppgave31;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/** Triviell kontroller som audit-testen kaller gjennom. Ikke endre. */
@RestController
public class PingController {

    @GetMapping("/ping")
    public String ping() {
        return "pong";
    }
}
