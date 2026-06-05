package no.digisis.hackathon.spor2.oppgave20;

import no.digisis.hackathon.spor2.domain.ForeldrepengerSoknad;
import no.digisis.hackathon.spor2.oppgave12.SoknadsRegister;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Oppgave 20 — GET /soknader (15 poeng)
 *
 * Returner alle soknader i registeret som JSON. Spring serialiserer
 * lista for deg.
 */
@RestController
public class SoknadAlleController {

    private final SoknadsRegister register;

    public SoknadAlleController(SoknadsRegister register) {
        this.register = register;
    }

    @GetMapping("/soknader")
    public List<ForeldrepengerSoknad> hentAlle() {
        // TODO
        throw new UnsupportedOperationException("Oppgave 20 — ikke implementert ennå");
    }
}
