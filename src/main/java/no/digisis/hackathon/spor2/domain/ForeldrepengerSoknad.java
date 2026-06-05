package no.digisis.hackathon.spor2.domain;

/**
 * En søknad om foreldrepenger som kommer inn til Direktoratet for
 * digital saksbehandling.
 *
 * <p>Verdiobjekt: identitet bestemmes av {@link Fodselsnummer}.
 */
public record ForeldrepengerSoknad(
        Fodselsnummer fnr,
        String fornavn,
        String etternavn,
        int alder,
        String postnummer,
        int manedsinntekt
) {

    public ForeldrepengerSoknad {
        if (fnr == null) throw new IllegalArgumentException("fnr må være satt");
        if (fornavn == null || fornavn.isBlank()) throw new IllegalArgumentException("fornavn må være satt");
        if (etternavn == null || etternavn.isBlank()) throw new IllegalArgumentException("etternavn må være satt");
        if (alder < 0) throw new IllegalArgumentException("alder kan ikke være negativ");
        if (postnummer == null || !postnummer.matches("\\d{4}"))
            throw new IllegalArgumentException("postnummer må være 4 sifre");
        if (manedsinntekt < 0) throw new IllegalArgumentException("manedsinntekt kan ikke være negativ");
    }
}
