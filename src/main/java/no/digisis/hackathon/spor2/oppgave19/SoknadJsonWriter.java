package no.digisis.hackathon.spor2.oppgave19;

import com.fasterxml.jackson.core.JsonProcessingException;

import no.digisis.hackathon.spor2.domain.ForeldrepengerSoknad;

/**
 * Oppgave 19 — Custom feltnavn & format (15 poeng)
 *
 * Direktoratets eksterne API bruker ANDRE feltnavn enn domenemodellen.
 * Produser JSON på formen:
 *
 *   {"foedselsnummer":"*******1234","navn":"Fornavn Etternavn",
 *    "postnr":"0560","inntekt":32000}
 *
 * der
 *   • foedselsnummer = fnr maskert som i oppgave 18 ({@code *******1234})
 *   • navn           = fornavn + " " + etternavn
 *   • postnr         = postnummer
 *   • inntekt        = manedsinntekt
 *
 * Domenefeltnavnene (fornavn, etternavn, fnr) skal IKKE være med i JSON-en.
 * Bygg en {@link EksternSoknad} (annotert med {@code @JsonProperty}) og
 * serialiser den med Jackson — eller bygg en {@code ObjectNode}/{@code Map}.
 */
public final class SoknadJsonWriter {

    private SoknadJsonWriter() {}

    public static String tilJson(ForeldrepengerSoknad soknad) throws JsonProcessingException {
        // TODO
        throw new UnsupportedOperationException("Oppgave 19 — ikke implementert ennå");
    }
}
