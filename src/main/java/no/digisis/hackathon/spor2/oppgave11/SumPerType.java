package no.digisis.hackathon.spor2.oppgave11;

import no.digisis.hackathon.spor2.domain.Inntektstype;
import no.digisis.hackathon.spor2.domain.Soknad;

import java.util.List;
import java.util.Map;

/**
 * Oppgave 11 — Flat-map & aggregering (20 poeng)
 *
 * Hver {@link Soknad} har en {@code inntektshistorikk} — en liste av
 * {@link no.digisis.hackathon.spor2.domain.Inntektsregistrering}. Flat ut
 * alle registreringene på tvers av alle soknadene, grupper på
 * {@link Inntektstype}, og summer {@code belop} per type.
 *
 * <p>Bruk {@code flatMap} for å folde ut historikkene, og
 * {@link java.util.stream.Collectors#groupingBy} med
 * {@link java.util.stream.Collectors#summingLong} som downstream.
 * Tom inputliste skal gi et tomt map; en type som ikke forekommer skal
 * ikke ha en nøkkel i resultatet.
 */
public final class SumPerType {

    private SumPerType() {}

    public static Map<Inntektstype, Long> sumPerType(List<Soknad> soknader) {
        // TODO: flatMap inntektshistorikk → grupper på type → summer belop.
        throw new UnsupportedOperationException("Oppgave 11 — ikke implementert ennå");
    }
}
