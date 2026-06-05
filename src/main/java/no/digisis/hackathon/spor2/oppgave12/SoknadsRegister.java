package no.digisis.hackathon.spor2.oppgave12;

import no.digisis.hackathon.spor2.domain.Fodselsnummer;
import no.digisis.hackathon.spor2.domain.ForeldrepengerSoknad;

import java.util.List;
import java.util.Optional;

/**
 * Oppgave 12 — In-memory søknadsregister (20 poeng)
 *
 * Implementer et lite register slik at:
 *   • leggTil overskriver eksisterende soknad med samme fnr
 *   • finn(fnr) returnerer Optional.empty() når ingen treff finnes
 *   • hentAlle() returnerer en "immutable" kopi
 *   • antall() reflekterer faktisk innhold
 *
 * Hold state innkapslet i et privat felt. Velg en datastruktur som
 * gir raskt oppslag på fnr.
 */
public final class SoknadsRegister {

    public void leggTil(ForeldrepengerSoknad soknad) {
        // TODO
        throw new UnsupportedOperationException("Oppgave 12 — ikke implementert ennå");
    }

    public Optional<ForeldrepengerSoknad> finn(Fodselsnummer fnr) {
        // TODO
        throw new UnsupportedOperationException("Oppgave 12 — ikke implementert ennå");
    }

    public List<ForeldrepengerSoknad> hentAlle() {
        // TODO
        throw new UnsupportedOperationException("Oppgave 12 — ikke implementert ennå");
    }

    public int antall() {
        // TODO
        throw new UnsupportedOperationException("Oppgave 12 — ikke implementert ennå");
    }
}
