package no.digisis.hackathon.spor2.oppgave33;

/**
 * Oppgave 33 — Robust HTTP-klient: timeout & fallback (20 poeng)
 *
 * Eksterne API-er feiler av og til: de henger, svarer 500, eller nettet
 * faller ut. En robust klient skal aldri kaste videre på dette — den skal
 * gi et tydelig {@link Status#UKJENT} og la kalleren bestemme videre.
 *
 * <p>Implementer {@code valider}:
 * <pre>
 *   POST {baseUrl}/api/fnr
 *     Content-Type: application/json
 *     body: fnr som JSON-streng
 * </pre>
 *
 * <ul>
 *   <li>{@code {"status":"valid"}}   → {@link Status#GYLDIG}</li>
 *   <li>{@code {"status":"invalid"}} → {@link Status#UGYLDIG}</li>
 *   <li>timeout / ikke-200 / IOException / parse-feil → {@link Status#UKJENT}
 *       (kast ALDRI videre)</li>
 * </ul>
 *
 * <p>Bruk en KORT request-timeout, f.eks.
 * {@code HttpRequest.newBuilder().timeout(Duration.ofMillis(300))}.
 */
public final class RobustFnrKlient {

    private RobustFnrKlient() {}

    public static Status valider(String fnr, String baseUrl) {
        // TODO
        throw new UnsupportedOperationException("Oppgave 33 — ikke implementert ennå");
    }
}
