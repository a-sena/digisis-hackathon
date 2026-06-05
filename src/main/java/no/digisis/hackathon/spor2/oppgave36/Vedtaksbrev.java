package no.digisis.hackathon.spor2.oppgave36;

import no.digisis.hackathon.spor2.oppgave35.Vedtak;

/**
 * Oppgave 36 — Vedtaksbrev (15 poeng)
 *
 * <p>Formuler én setning per utfall ut fra et {@link Vedtak}. Bruk en
 * <b>uttømmende</b> {@code switch} med pattern matching over sum-typen
 * (fra oppgave 35) — da klager kompilatoren hvis du glemmer en variant,
 * og du slipper en {@code default}-gren.
 *
 * <p>Tekstene (eksakt):
 * <ul>
 *   <li>{@link Vedtak.Innvilget} →
 *       {@code "Søknaden er innvilget med et grunnlag på " + grunnlag + " kr."}</li>
 *   <li>{@link Vedtak.Engangsstonad} → {@code "Du får engangsstønad."}</li>
 *   <li>{@link Vedtak.Avslag} → {@code "Søknaden er avslått."}</li>
 *   <li>{@link Vedtak.ManuellVurdering} → {@code "Saken går til manuell vurdering."}</li>
 * </ul>
 */
public final class Vedtaksbrev {

    private Vedtaksbrev() {}

    public static String brev(Vedtak vedtak) {
        // TODO
        throw new UnsupportedOperationException("Oppgave 36 — ikke implementert ennå");
    }
}
