package no.digisis.hackathon.spor2.oppgave18;

import no.digisis.hackathon.spor2.domain.ForeldrepengerSoknad;

/**
 * Oppgave 18 — DTO ↔ domene-mapping (15 poeng)
 *
 * Domeneobjektet {@link ForeldrepengerSoknad} skal ikke lekke rått ut av
 * tjenesten. Mapp det til en {@link SoknadDto} der:
 *
 *   • navn        = fornavn + " " + etternavn
 *   • maskertFnr  = fnr med alt unntatt de 4 siste sifrene erstattet med
 *                   {@code *} (et 11-sifret fnr blir {@code *******1234})
 *   • postnummer  kopieres uendret
 *   • manedsinntekt kopieres uendret
 *
 * Det rå fnr-et skal ALDRI havne i DTO-en.
 */
public final class SoknadMapper {

    private SoknadMapper() {}

    public static SoknadDto tilDto(ForeldrepengerSoknad soknad) {
        // TODO
        throw new UnsupportedOperationException("Oppgave 18 — ikke implementert ennå");
    }
}
