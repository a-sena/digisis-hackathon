package no.digisis.hackathon.spor2.oppgave04;

/**
 * En hendelse som kan inntreffe på en sak. Sum-type (sealed) med tre
 * varianter — ferdig definert, du skal ikke endre den.
 *
 * <ul>
 *   <li>{@link StartBehandling} — en saksbehandler tar saken.</li>
 *   <li>{@link FattVedtak} — det fattes et vedtak med et utfall.</li>
 *   <li>{@link Avvis} — saken avvises med en begrunnelse.</li>
 * </ul>
 */
public sealed interface Hendelse
        permits Hendelse.StartBehandling, Hendelse.FattVedtak, Hendelse.Avvis {

    record StartBehandling(String saksbehandler) implements Hendelse {}

    record FattVedtak(String utfall) implements Hendelse {}

    record Avvis(String grunn) implements Hendelse {}
}
