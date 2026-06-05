package no.digisis.hackathon.spor2.oppgave04;

/**
 * Tilstanden en sak kan være i. Sum-type (sealed) med fire varianter —
 * ferdig definert, du skal ikke endre den.
 *
 * <ul>
 *   <li>{@link Mottatt} — saken er registrert, men ikke påbegynt.</li>
 *   <li>{@link UnderBehandling} — en saksbehandler jobber med saken.</li>
 *   <li>{@link Vedtak} — saken er avgjort med et utfall.</li>
 *   <li>{@link Avvist} — saken er avvist med en begrunnelse.</li>
 * </ul>
 */
public sealed interface Saksstatus
        permits Saksstatus.Mottatt, Saksstatus.UnderBehandling, Saksstatus.Vedtak, Saksstatus.Avvist {

    record Mottatt() implements Saksstatus {}

    record UnderBehandling(String saksbehandler) implements Saksstatus {}

    record Vedtak(String utfall) implements Saksstatus {}

    record Avvist(String grunn) implements Saksstatus {}
}
