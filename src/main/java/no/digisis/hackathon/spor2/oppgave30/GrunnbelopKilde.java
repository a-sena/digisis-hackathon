package no.digisis.hackathon.spor2.oppgave30;

import org.springframework.stereotype.Component;

/**
 * Ferdig komponent — du skal IKKE endre denne. En enkel kilde for
 * grunnbeløpet (G), eksponert som en Spring-bønne slik at
 * {@link BeregningService} kan få den injisert.
 */
@Component
public class GrunnbelopKilde {

    public int grunnbelop() {
        return 118620;
    }
}
