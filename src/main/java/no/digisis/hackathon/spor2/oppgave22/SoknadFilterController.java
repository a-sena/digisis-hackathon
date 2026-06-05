package no.digisis.hackathon.spor2.oppgave22;

import no.digisis.hackathon.spor2.domain.ForeldrepengerSoknad;
import no.digisis.hackathon.spor2.oppgave12.SoknadsRegister;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Oppgave 22 — GET /soknader/filter?minInntekt=X&maxAlder=Y (15 poeng)
 *
 * Returner kun de soknadene som matcher begge kriteriene:
 *   • månedsinntekt ≥ {@code minInntekt} (default 0 — slipper alle gjennom)
 *   • alder ≤ {@code maxAlder} (default {@link Integer#MAX_VALUE} — slipper alle gjennom)
 *
 * Begge parameterne er valgfrie. Mangler begge → returner alle.
 *
 * Eksempel:
 *   GET /soknader/filter?minInntekt=30000          → inntekt ≥ 30 000
 *   GET /soknader/filter?maxAlder=34               → alder ≤ 34
 *   GET /soknader/filter?minInntekt=30000&maxAlder=34
 */
@RestController
public class SoknadFilterController {

    private final SoknadsRegister register;

    public SoknadFilterController(SoknadsRegister register) {
        this.register = register;
    }

    @GetMapping("/soknader/filter")
    public List<ForeldrepengerSoknad> filtrer(
            @RequestParam(defaultValue = "0") int minInntekt,
            @RequestParam(defaultValue = "2147483647") int maxAlder) {
        // TODO: filtrer registeret på begge kriteriene.
        throw new UnsupportedOperationException("Oppgave 22 — ikke implementert ennå");
    }
}
