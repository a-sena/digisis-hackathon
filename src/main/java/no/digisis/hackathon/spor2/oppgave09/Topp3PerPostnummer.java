package no.digisis.hackathon.spor2.oppgave09;

import no.digisis.hackathon.spor2.domain.ForeldrepengerSoknad;

import java.util.List;
import java.util.Map;

/**
 * Oppgave 9 — Topp-3 inntekt per postnummer (15 poeng)
 *
 * For hvert postnummer, returner de tre sakene med høyest månedsinntekt
 * (fallende rekkefølge). Hvis det er færre enn tre soknader i et postnummer,
 * returner alle.
 *
 * Bruk Stream API. Postnummer med 0 soknader skal ikke være med i resultatet.
 */
public final class Topp3PerPostnummer {

    private Topp3PerPostnummer() {}

    public static Map<String, List<ForeldrepengerSoknad>> finn(List<ForeldrepengerSoknad> soknader) {
        // TODO: grupper på postnummer, sorter hver gruppe synkende på månedsinntekt,
        //       og behold opptil 3 elementer.
        throw new UnsupportedOperationException("Oppgave 9 — ikke implementert ennå");
    }
}
