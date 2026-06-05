package no.digisis.hackathon.spor2.oppgave13;

import java.util.List;
import java.util.Optional;
import java.util.function.Function;

/**
 * Oppgave 13 — Generisk register (20 poeng)
 *
 * <p>Et gjenbrukbart in-memory register, parametrisert over entitetstypen
 * {@code T} og id-typen {@code ID}. Konstruktøren får en <i>nøkkelfunksjon</i>
 * {@code idAv} som henter id-en ut av en entitet — slik kan samme register
 * brukes for søknader (id = fnr), personer (id = epost), hva som helst.
 *
 * <ul>
 *   <li>{@code leggTil(t)} — lagrer t; overskriver hvis id-en finnes fra før</li>
 *   <li>{@code finn(id)}   — {@link Optional} med entiteten, eller tom</li>
 *   <li>{@code hentAlle()} — alle entiteter (uforanderlig kopi)</li>
 *   <li>{@code antall()}   — antall unike id-er</li>
 * </ul>
 *
 * Velg en datastruktur med raskt oppslag på id ({@code idAv} er allerede
 * tatt imot for deg).
 */
public final class Register<T, ID> {

    private final Function<T, ID> idAv;

    public Register(Function<T, ID> idAv) {
        this.idAv = idAv;
    }

    public void leggTil(T t) {
        // TODO (bruk this.idAv.apply(t) for å finne nøkkelen)
        throw new UnsupportedOperationException("Oppgave 13 — ikke implementert ennå");
    }

    public Optional<T> finn(ID id) {
        // TODO
        throw new UnsupportedOperationException("Oppgave 13 — ikke implementert ennå");
    }

    public List<T> hentAlle() {
        // TODO
        throw new UnsupportedOperationException("Oppgave 13 — ikke implementert ennå");
    }

    public int antall() {
        // TODO
        throw new UnsupportedOperationException("Oppgave 13 — ikke implementert ennå");
    }
}
