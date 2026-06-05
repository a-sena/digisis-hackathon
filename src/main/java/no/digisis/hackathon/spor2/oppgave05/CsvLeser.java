package no.digisis.hackathon.spor2.oppgave05;

import no.digisis.hackathon.spor2.domain.ForeldrepengerSoknad;

import java.nio.file.Path;
import java.util.List;

/**
 * Oppgave 5 — Les soknader fra CSV (15 poeng)
 *
 * <p>Format (én header-linje, deretter én soknad per linje):
 * <pre>fnr,fornavn,etternavn,alder,postnummer,manedsinntekt</pre>
 *
 * <p>Krav:
 * <ul>
 *   <li>Returner kun gyldige soknader. En soknad er gyldig når:
 *     <ul>
 *       <li>Alle felt kan parses til riktig type.</li>
 *       <li>{@link ForeldrepengerSoknad}-konstruktøren ikke kaster Exception
 *           (blanke tekstfelt og negative tall avvises der).</li>
 *       <li>fnr passerer validering via et HTTP-kall til
 *           {@code https://api.digisis.org/api/fnr}.</li>
 *     </ul>
 *   </li>
 *   <li>Ugyldige linjer hoppes over uten å kaste Exception.</li>
 * </ul>
 *
 * <p>API-kontrakt for fnr-validering:
 * <ul>
 *   <li>Metode: {@code POST}</li>
 *   <li>URL: {@code {baseUrl}/api/fnr} (produksjon: {@code https://api.digisis.org})</li>
 *   <li>Content-Type: {@code application/json}</li>
 *   <li>Body: fnr som JSON-streng, f.eks. {@code "01059010006"}
 *       (med anførselstegnene — body-en er en JSON-streng, ikke et objekt).</li>
 *   <li>Svar (200 OK):
 *     <pre>
 * {"status": "valid",   "type": "fnr"}
 * {"status": "invalid", "reasons": ["checksums don't match"]}
 *     </pre>
 *   </li>
 *   <li>Kun {@code status == "valid"} regnes som godkjent fnr.</li>
 * </ul>
 */
public final class CsvLeser {

    private CsvLeser() {}

    /** Produksjon: validerer fnr mot api.digisis.org. */
    public static List<ForeldrepengerSoknad> les(Path csv) {
        return les(csv, "https://api.digisis.org");
    }

    /**
     * Som {@link #les(Path)}, men med en valgfri base-URL for fnr-API-et.
     * Testene sender inn en lokal stub-server her, så de slipper å nå
     * internett — og slipper Mod-11: gyldighet bestemmes av stubben.
     */
    public static List<ForeldrepengerSoknad> les(Path csv, String baseUrl) {
        // TODO
        throw new UnsupportedOperationException("Oppgave 5 — ikke implementert ennå");
    }

    // Hint: del problemet i tre.
    //
    //   1) Splitt linjen ved komma og hent ut hvert felt:
    //        fnr           → String
    //        fornavn       → String
    //        etternavn     → String
    //        alder         → int
    //        postnummer    → String
    //        manedsinntekt → int
    //   2) Validér fnr ved å POSTe det til {baseUrl}/api/fnr og les
    //      "status"-feltet av JSON-svaret.
    //   3) Hvis (1) og (2) gikk bra, bygg ForeldrepengerSoknad og legg den
    //      i resultatlista.
    //
    // Bruk java.net.http.HttpClient til HTTP-kallet og Jackson sin
    // ObjectMapper til å parse JSON-svaret.
}
