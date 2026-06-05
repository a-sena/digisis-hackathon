package no.digisis.hackathon.spor2.domain;

import java.util.List;

/**
 * Den «fulle» foreldrepenger-søknaden — samme form som API-et
 * {@code GET https://api.digisis.org/api/foreldrepenger/soknader}
 * returnerer. Brukes av oppgavene 15–17 og 20 (vedtaksmotor,
 * stønadsperiode, rapport). Dette er en RIKERE modell enn
 * {@link ForeldrepengerSoknad} (som dekker CSV-/REST-oppgavene 1–14).
 *
 * <p>Ferdig definert — du skal ikke endre den, men du må kjenne feltene.
 *
 * @param rettsforhold én av {@code "begge"}, {@code "kun-mor"}, {@code "kun-far"}
 * @param dekningsgrad 100 eller 80
 * @param termindato   ISO-dato {@code YYYY-MM-DD}
 * @param oppgittArsinntekt søkers oppgitte årsinntekt; 0 = ikke oppgitt
 * @param inntektshistorikk inntektsmåneder fra a-ordningen, eldste først
 */
public record Soknad(
        String id,
        String beskrivelse,
        String fnr,
        boolean erNorskBorger,
        String termindato,
        int oppgittArsinntekt,
        List<Inntektsregistrering> inntektshistorikk,
        int antallBarn,
        String rettsforhold,
        int dekningsgrad
) {}
