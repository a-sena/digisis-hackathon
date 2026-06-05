package no.digisis.hackathon.spor2.oppgave26;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
 * Ferdig kontroller — du skal IKKE endre denne. Den kaster
 * {@link SakIkkeFunnet} for ukjente id-er. Jobben din ligger i
 * {@link FeilHandtering}: gjør exceptionen om til 404 sentralt, slik at
 * kontrolleren slipper å returnere statuskoder selv.
 */
@RestController
public class SakController {

    @GetMapping("/saker/{id}")
    public Sak hent(@PathVariable String id) {
        if (!id.equals("1")) {
            throw new SakIkkeFunnet("sak " + id + " finnes ikke");
        }
        return new Sak("1", "Aktiv");
    }
}
