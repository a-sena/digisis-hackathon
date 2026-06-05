package no.digisis.hackathon.spor2.domain;

import java.util.regex.Pattern;

/**
 * Verdiobjekt for fødselsnummer. Domeneobjektet sjekker bare *format* —
 * nøyaktig 11 sifre — slik at testdataene flyter gjennom pipelinen
 * uten å avvise gyldige fnr. Full Mod-11-validering er bevisst utelatt.
 *
 * <p>Identitet bestemmes av {@link #verdi}.
 */
public record Fodselsnummer(String verdi) {

    private static final Pattern ELLEVE_SIFRE = Pattern.compile("\\d{11}");

    public Fodselsnummer {
        if (verdi == null || !ELLEVE_SIFRE.matcher(verdi).matches()) {
            throw new IllegalArgumentException("fnr må være 11 sifre: " + verdi);
        }
    }

    public static Fodselsnummer av(String verdi) {
        return new Fodselsnummer(verdi);
    }
}
