package no.digisis.hackathon.spor2.oppgave33;

/**
 * Resultatet av et fnr-valideringskall mot et eksternt API.
 *
 * <p>Ferdig definert — du skal returnere én av disse fra
 * {@link RobustFnrKlient#valider}.
 *
 * <ul>
 *   <li>{@code GYLDIG}  — API-et svarte {@code {"status":"valid"}}</li>
 *   <li>{@code UGYLDIG} — API-et svarte {@code {"status":"invalid"}}</li>
 *   <li>{@code UKJENT}  — vi fikk ikke et brukbart svar (timeout, feilkode,
 *       nettfeil, parse-feil). Vi vet rett og slett ikke.</li>
 * </ul>
 */
public enum Status {
    GYLDIG,
    UGYLDIG,
    UKJENT
}
