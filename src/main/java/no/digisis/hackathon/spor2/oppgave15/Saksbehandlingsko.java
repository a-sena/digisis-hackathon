package no.digisis.hackathon.spor2.oppgave15;

import no.digisis.hackathon.spor2.domain.ForeldrepengerSoknad;

import java.util.Optional;

/**
 * Oppgave 15 — Prioritert saksbehandlingskø (20 poeng)
 *
 * <p>En kø som alltid gir ut den <b>høyest prioriterte</b> saken først.
 * Prioritetsregelen for foreldrepenger-saker:
 *
 * <ol>
 *   <li><b>Lavest månedsinntekt først</b> — de mest trengende søkerne
 *       behandles først.</li>
 *   <li>Ved lik inntekt: <b>yngst alder først</b>.</li>
 * </ol>
 *
 * <ul>
 *   <li>{@code leggTil(soknad)} — setter en sak i køen</li>
 *   <li>{@code nesteSak()}      — FJERNER og returnerer høyest prioriterte
 *       sak, eller {@link Optional#empty()} hvis køen er tom</li>
 *   <li>{@code antall()}        — antall saker i køen</li>
 * </ul>
 *
 * Bruk en {@link java.util.PriorityQueue} med en passende
 * {@link java.util.Comparator}.
 */
public final class Saksbehandlingsko {

    public void leggTil(ForeldrepengerSoknad soknad) {
        // TODO: sett saken i en PriorityQueue med riktig Comparator.
        throw new UnsupportedOperationException("Oppgave 15 — ikke implementert ennå");
    }

    public Optional<ForeldrepengerSoknad> nesteSak() {
        // TODO: fjern og returner høyest prioriterte sak (eller tom).
        throw new UnsupportedOperationException("Oppgave 15 — ikke implementert ennå");
    }

    public int antall() {
        // TODO
        throw new UnsupportedOperationException("Oppgave 15 — ikke implementert ennå");
    }
}
