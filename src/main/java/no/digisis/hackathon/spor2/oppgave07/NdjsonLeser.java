package no.digisis.hackathon.spor2.oppgave07;

import no.digisis.hackathon.spor2.domain.Soknad;

import java.util.List;

/**
 * Oppgave 7 — Les NDJSON tolerant (15 poeng)
 *
 * <p>NDJSON («newline-delimited JSON») er én JSON-verdi per linje. Her er
 * hver linje en {@link Soknad} (den rike API-modellen, ikke
 * {@code ForeldrepengerSoknad}).
 *
 * <p>Krav til {@link #les(String)}:
 * <ul>
 *   <li>Parse hver linje for seg til en {@link Soknad}.</li>
 *   <li>Hopp over blanke linjer.</li>
 *   <li>Hopp over linjer som ikke lar seg parse (ugyldig JSON) — uten å
 *       kaste. Resten skal fortsatt komme med.</li>
 *   <li>Returner søknadene i samme rekkefølge som i teksten.</li>
 * </ul>
 *
 * <p>Bruk Jackson sin {@code ObjectMapper} til å lese hver linje, og pakk
 * kallet i {@code try/catch} så en råtten linje ikke velter resten.
 */
public final class NdjsonLeser {

    private NdjsonLeser() {}

    public static List<Soknad> les(String tekst) {
        // TODO
        throw new UnsupportedOperationException("Oppgave 7 — ikke implementert ennå");
    }
}
