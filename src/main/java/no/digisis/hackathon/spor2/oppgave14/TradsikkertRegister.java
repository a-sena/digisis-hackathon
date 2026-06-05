package no.digisis.hackathon.spor2.oppgave14;

import no.digisis.hackathon.spor2.domain.Fodselsnummer;
import no.digisis.hackathon.spor2.domain.ForeldrepengerSoknad;

import java.util.Optional;

/**
 * Oppgave 14 — Trådsikkert register (20 poeng)
 *
 * <p>Et register for {@link ForeldrepengerSoknad}, nøklet på fnr, som er
 * korrekt under <b>samtidige skrivinger</b> fra flere tråder. Hvis to
 * tråder kaller {@code leggTil} samtidig skal ingen oppdateringer gå tapt.
 *
 * <p>I Java løses dette med en trådsikker datastruktur — bruk
 * {@link java.util.concurrent.ConcurrentHashMap} i stedet for en vanlig
 * {@code HashMap}. (En vanlig {@code HashMap} kan miste skrivinger eller
 * havne i en korrupt tilstand når den oppdateres uten synkronisering.)
 *
 * <ul>
 *   <li>{@code leggTil(soknad)} — lagrer; overskriver samme fnr</li>
 *   <li>{@code finn(fnr)}       — {@link Optional} med soknaden, eller tom</li>
 *   <li>{@code antall()}        — antall unike fnr</li>
 * </ul>
 */
public final class TradsikkertRegister {

    public void leggTil(ForeldrepengerSoknad soknad) {
        // TODO: lagre soknad nøklet på soknad.fnr() i en ConcurrentHashMap.
        throw new UnsupportedOperationException("Oppgave 14 — ikke implementert ennå");
    }

    public Optional<ForeldrepengerSoknad> finn(Fodselsnummer fnr) {
        // TODO
        throw new UnsupportedOperationException("Oppgave 14 — ikke implementert ennå");
    }

    public int antall() {
        // TODO
        throw new UnsupportedOperationException("Oppgave 14 — ikke implementert ennå");
    }
}
