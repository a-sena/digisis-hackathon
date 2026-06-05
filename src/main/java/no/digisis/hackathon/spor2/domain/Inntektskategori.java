package no.digisis.hackathon.spor2.domain;

/**
 * Inntektskategori brukt av flere oppgaver. Denne er ferdig implementert
 * — du skal ikke endre den, men du må kjenne grensene:
 *
 *   < 30 000        → LAV
 *   30 000–60 000   → MIDDELS
 *   > 60 000        → HOY
 */
public enum Inntektskategori {
    LAV,
    MIDDELS,
    HOY;

    public static Inntektskategori av(int manedslonn) {
        if (manedslonn < 30_000) return LAV;
        if (manedslonn <= 60_000) return MIDDELS;
        return HOY;
    }
}
