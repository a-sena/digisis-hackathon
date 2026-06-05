package no.digisis.hackathon.spor2.oppgave34;

import java.util.function.Supplier;

/**
 * Oppgave 34 — Retry med backoff (20 poeng)
 *
 * Et kall mot en ustabil tjeneste lykkes ofte hvis du bare prøver på nytt.
 * Implementer en generisk retry-hjelper:
 *
 * <ul>
 *   <li>kall {@code kall.get()}</li>
 *   <li>hvis det kaster: prøv igjen, opptil {@code forsok} forsøk totalt</li>
 *   <li>returner det første vellykkede resultatet</li>
 *   <li>hvis alle forsøk kaster: kast det SISTE unntaket videre</li>
 * </ul>
 *
 * <p>I produksjon ville du ventet litt mellom forsøkene (backoff) — her
 * holder vi det deterministisk og hopper over sleep. En kommentar der
 * pausen ville vært, holder.
 */
public final class Retry {

    private Retry() {}

    public static <T> T medRetry(Supplier<T> kall, int forsok) {
        // TODO
        throw new UnsupportedOperationException("Oppgave 34 — ikke implementert ennå");
    }
}
