package no.digisis.hackathon.spor2.oppgave16;

import com.fasterxml.jackson.core.JsonProcessingException;

import no.digisis.hackathon.spor2.domain.ForeldrepengerSoknad;

/**
 * Oppgave 16 — Serialiser ForeldrepengerSoknad til JSON (15 poeng)
 *
 * Spring Boot serialiserer automatisk for deg, men her skal du gjøre
 * det selv med Jackson. Det hjelper deg å forstå *hva* framework gjør
 * når du møter en bug eller skal tilpasse output i fremtiden.
 *
 * Bruk en {@code ObjectMapper}. Resultatet skal være gyldig JSON som
 * inneholder alle feltene fra {@link ForeldrepengerSoknad}. Eksempel:
 *
 *   {"fnr":{"verdi":"..."}, "fornavn":"...", "etternavn":"...", ...}
 */
public final class SoknadSerializer {

    private SoknadSerializer() {}

    public static String tilJson(ForeldrepengerSoknad soknad) throws JsonProcessingException {
        // TODO
        throw new UnsupportedOperationException("Oppgave 16 — ikke implementert ennå");
    }
}
