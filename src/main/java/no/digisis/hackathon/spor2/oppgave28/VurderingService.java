package no.digisis.hackathon.spor2.oppgave28;

import no.digisis.hackathon.spor2.domain.Fodselsnummer;
import no.digisis.hackathon.spor2.oppgave12.SoknadsRegister;

import org.springframework.stereotype.Service;

/**
 * Oppgave 28 — Tjenestelag og dependency injection (15 poeng)
 *
 * Et {@code @Service} er en Spring-bønne som kapsler inn forretningslogikk.
 * Her injiseres {@link SoknadsRegister} via konstruktøren.
 *
 * Implementer {@link #vurder}: slå opp soknaden på fnr og returner
 *   • "berettiget"       hvis månedsinntekt < 35 000,
 *   • "ikke berettiget"  hvis månedsinntekt ≥ 35 000,
 *   • "ukjent"           hvis ingen soknad finnes.
 */
@Service
public class VurderingService {

    private final SoknadsRegister register;

    public VurderingService(SoknadsRegister register) {
        this.register = register;
    }

    public String vurder(String fnr) {
        // TODO: slå opp i registeret og returner "berettiget"/"ikke berettiget"/"ukjent".
        throw new UnsupportedOperationException("Oppgave 28 — ikke implementert ennå");
    }
}
