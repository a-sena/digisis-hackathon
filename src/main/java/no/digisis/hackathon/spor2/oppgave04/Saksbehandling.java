package no.digisis.hackathon.spor2.oppgave04;

import no.digisis.hackathon.spor2.oppgave03.Beloep;

/**
 * Oppgave 4 — Saksstatus-tilstandsmaskin (20 poeng)
 *
 * <p>Gitt en {@link Saksstatus} og en {@link Hendelse}, regn ut neste
 * status. Bare disse overgangene er lovlige:
 *
 * <pre>
 *   Mottatt          + StartBehandling(sb) → UnderBehandling(sb)
 *   UnderBehandling  + FattVedtak(utfall)  → Vedtak(utfall)
 *   UnderBehandling  + Avvis(grunn)        → Avvist(grunn)
 * </pre>
 *
 * <p>ALLE andre kombinasjoner er ulovlige og skal kaste
 * {@link IllegalStateException} (f.eks. å fatte vedtak på en sak som
 * ennå ikke er påbegynt, eller å starte behandling på en allerede
 * avgjort sak).
 *
 * <p>Bruk et uttømmende {@code switch} med pattern-matching over
 * {@code (status, hendelse)}. Sum-typene er {@code sealed}, så
 * kompilatoren hjelper deg å dekke alle tilfeller.
 */
public final class Saksbehandling {

    private Saksbehandling() {}

    public static Saksstatus neste(Saksstatus status, Hendelse hendelse) {
        // TODO

        if (status instanceof Saksstatus.Mottatt) {

            if (hendelse instanceof Hendelse.StartBehandling h) {
                return new Saksstatus.UnderBehandling(h.saksbehandler());
            }
        }

        else if (status instanceof Saksstatus.UnderBehandling) {

            if (hendelse instanceof Hendelse.FattVedtak h) {
                return new Saksstatus.Vedtak(h.utfall());
            }

            if (hendelse instanceof Hendelse.Avvis h) {
                return new Saksstatus.Avvist(h.grunn());
            }
        }


        throw new IllegalStateException("Try again");
    }
}