package no.digisis.hackathon.spor2.oppgave30;

import no.digisis.hackathon.spor2.domain.Fodselsnummer;
import no.digisis.hackathon.spor2.oppgave12.SoknadsRegister;

import org.springframework.stereotype.Service;

/**
 * Oppgave 30 — Komponerte tjenester (15 poeng)
 *
 * Denne tjenesten komponerer TO samarbeidspartnere: {@link SoknadsRegister}
 * (data) og {@link GrunnbelopKilde} (G). Begge injiseres via konstruktøren.
 *
 * Implementer {@link #andelAvG}: regn ut søkerens årsinntekt som prosent av
 * grunnbeløpet, avrundet til heltall:
 *
 *   andel = manedsinntekt × 12 × 100 / G
 *
 * Returner -1 hvis ingen soknad finnes for fnr.
 */
@Service
public class BeregningService {

    private final SoknadsRegister register;
    private final GrunnbelopKilde gKilde;

    public BeregningService(SoknadsRegister register, GrunnbelopKilde gKilde) {
        this.register = register;
        this.gKilde = gKilde;
    }

    public int andelAvG(String fnr) {
        // TODO: slå opp soknaden, regn ut årsinntekt som prosent av G, ellers -1.
        throw new UnsupportedOperationException("Oppgave 30 — ikke implementert ennå");
    }
}
