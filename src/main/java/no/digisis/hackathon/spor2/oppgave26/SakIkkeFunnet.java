package no.digisis.hackathon.spor2.oppgave26;

/** Kastes når en sak ikke finnes. {@code FeilHandtering} gjør den til 404. */
public class SakIkkeFunnet extends RuntimeException {
    public SakIkkeFunnet(String melding) {
        super(melding);
    }
}
