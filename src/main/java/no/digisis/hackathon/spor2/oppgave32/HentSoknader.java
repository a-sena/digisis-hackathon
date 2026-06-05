package no.digisis.hackathon.spor2.oppgave32;

import no.digisis.hackathon.spor2.domain.Soknad;

import java.util.List;

/**
 * Oppgave 32 — Hent & valider søknader fra API (20 poeng)
 *
 * <p>Hent listen med foreldrepenger-søknader fra
 * {@code GET {baseUrl}/api/foreldrepenger/soknader} (JSON-array av Soknad)
 * og returner kun de søknadene der fnr-et er gyldig. Hvert fnr valideres
 * mot {@code POST {baseUrl}/api/fnr}:
 * <pre>
 *   Content-Type: application/json
 *   body: fnr som JSON-streng, f.eks. "04059012377"
 *   svar: {"status":"valid", ...} | {"status":"invalid", ...}
 * </pre>
 *
 * <p><b>VIKTIG</b> — valider alle fnr <b>parallelt</b> (ikke ett om gangen).
 * Med ~12 søknader blir sekvensiell validering unødig treg; bruk f.eks.
 * {@code parallelStream()}. Bevar rekkefølgen fra listen.
 *
 * <p>Det er ingen lokal Mod-11-beregning her — du stoler på API-svaret.
 * Bruk {@code java.net.http.HttpClient} og Jackson ({@code ObjectMapper})
 * for parsing.
 */
public final class HentSoknader {

    private HentSoknader() {}

    public static List<Soknad> hentGyldigeSoknader() {
        return hentGyldigeSoknader("https://api.digisis.org");
    }

    public static List<Soknad> hentGyldigeSoknader(String baseUrl) {
        // TODO
        throw new UnsupportedOperationException("Oppgave 32 — ikke implementert ennå");
    }
}
