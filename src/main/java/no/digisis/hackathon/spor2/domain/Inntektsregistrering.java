package no.digisis.hackathon.spor2.domain;

/**
 * Én inntektsmåned fra a-ordningen.
 *
 * @param maned kalendermåned, format {@code YYYY-MM}
 * @param type  inntektstype (se {@link Inntektstype})
 * @param belop brutto utbetalt i kroner (heltall, ≥ 0)
 */
public record Inntektsregistrering(String maned, Inntektstype type, int belop) {}
