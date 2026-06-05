package no.digisis.hackathon.spor2.oppgave27;

/** Kastes når et vedtak ikke finnes. {@code ProblemDetaljHandtering} gjør den til 404. */
public class VedtakIkkeFunnet extends RuntimeException {
    public VedtakIkkeFunnet(String melding) {
        super(melding);
    }
}
