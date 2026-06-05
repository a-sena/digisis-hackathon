package no.digisis.hackathon.spor2.oppgave21;

import no.digisis.hackathon.spor2.domain.Fodselsnummer;
import no.digisis.hackathon.spor2.domain.ForeldrepengerSoknad;
import no.digisis.hackathon.spor2.oppgave12.SoknadsRegister;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
 * Oppgave 21 — GET /soknader/{fnr} (15 poeng)
 *
 * Returner soknaden som tilhører gitt fnr — eller 404 Not Found hvis ingen
 * soknad finnes. Bruk {@link ResponseEntity} for å kontrollere statuskoden.
 */
@RestController
public class SoknadHentController {

    private final SoknadsRegister register;

    public SoknadHentController(SoknadsRegister register) {
        this.register = register;
    }

    @GetMapping("/soknader/{fnr}")
    public ResponseEntity<ForeldrepengerSoknad> hent(@PathVariable String fnr) {
        // TODO: slå opp i registeret. Hvis funnet → 200 OK med soknad,
        //       hvis ikke → 404 Not Found.
        throw new UnsupportedOperationException("Oppgave 21 — ikke implementert ennå");
    }
}
