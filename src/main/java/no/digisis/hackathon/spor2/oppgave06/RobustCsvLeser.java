package no.digisis.hackathon.spor2.oppgave06;

import no.digisis.hackathon.spor2.domain.ForeldrepengerSoknad;

import java.nio.file.Path;
import java.util.List;

/**
 * Oppgave 6 — Robust parsing med feilsamling (20 poeng)
 *
 * <p>Som oppgave 5, men nå skal IKKE en enkelt feil-linje stoppe hele
 * innlesningen — og vi validerer ikke fnr mot API-et her (ren parsing).
 *
 * <p>Format (én header-linje, deretter én soknad per linje):
 * <pre>fnr,fornavn,etternavn,alder,postnummer,manedsinntekt</pre>
 *
 * <p>Krav til {@link #les(Path)}:
 * <ul>
 *   <li>Returner et {@link Resultat} med to lister:
 *     <ul>
 *       <li>{@code gyldige} — de {@link ForeldrepengerSoknad} som lot seg
 *           bygge.</li>
 *       <li>{@code feil} — én melding per linje som feilet, på formen
 *           {@code "linje N: <forklaring>"} (N er linjenummeret i fila,
 *           header er linje 1).</li>
 *     </ul>
 *   </li>
 *   <li>Metoden skal ALDRI kaste på en feil-linje — den fanger feilen,
 *       noterer den i {@code feil}, og fortsetter med neste linje.</li>
 *   <li>Validering trigges av {@link ForeldrepengerSoknad}-konstruktøren
 *       (blank tekst, negative tall, ugyldig postnummer) og av tall-
 *       parsing (ikke-numerisk alder/inntekt).</li>
 * </ul>
 */
public final class RobustCsvLeser {

    private RobustCsvLeser() {}

    public static Resultat les(Path csv) {
        // TODO
        throw new UnsupportedOperationException("Oppgave 6 — ikke implementert ennå");
    }

    public record Resultat(List<ForeldrepengerSoknad> gyldige, List<String> feil) {}
}
