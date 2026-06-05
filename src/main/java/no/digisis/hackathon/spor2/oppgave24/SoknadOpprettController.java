package no.digisis.hackathon.spor2.oppgave24;

import jakarta.validation.Valid;
import no.digisis.hackathon.spor2.domain.ForeldrepengerSoknad;
import no.digisis.hackathon.spor2.oppgave12.SoknadsRegister;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * Oppgave 24 — POST /soknader med Bean Validation (20 poeng)
 *
 * Implementer POST /soknader. Gyldig request gir 201 Created med en
 * Location-header (peker på /soknader/{fnr}). Ugyldig input (feil fnr,
 * blankt navn, feil postnummer …) skal gi 400 Bad Request — det skjer
 * automatisk via {@code @Valid} på request-DTO-en.
 */
@RestController
public class SoknadOpprettController {

    private final SoknadsRegister register;

    public SoknadOpprettController(SoknadsRegister register) {
        this.register = register;
    }

    @PostMapping("/soknader")
    public ResponseEntity<ForeldrepengerSoknad> opprett(@Valid @RequestBody OpprettSoknadRequest request) {
        // TODO: bygg en ForeldrepengerSoknad fra request, legg den i registeret,
        //       og returner 201 Created med en Location-header til /soknader/{fnr}.
        throw new UnsupportedOperationException("Oppgave 24 — ikke implementert ennå");
    }
}
