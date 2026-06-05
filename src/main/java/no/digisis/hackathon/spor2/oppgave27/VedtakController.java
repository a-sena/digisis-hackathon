package no.digisis.hackathon.spor2.oppgave27;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
 * Ferdig kontroller — du skal IKKE endre denne. Den kaster
 * {@link VedtakIkkeFunnet} for ukjente id-er. Jobben din ligger i
 * {@link ProblemDetaljHandtering}: gjør exceptionen om til en
 * {@code ProblemDetail} (RFC 7807) med status 404.
 */
@RestController
public class VedtakController {

    @GetMapping("/vedtak/{id}")
    public Vedtaksak hent(@PathVariable String id) {
        if (!id.equals("1")) {
            throw new VedtakIkkeFunnet("vedtak " + id + " finnes ikke");
        }
        return new Vedtaksak("1", "Innvilget");
    }
}
