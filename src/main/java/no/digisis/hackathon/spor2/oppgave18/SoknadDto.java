package no.digisis.hackathon.spor2.oppgave18;

/**
 * Utgående DTO — den «trygge» visningen av en søknad som kan sendes ut
 * av direktoratet. Råfødselsnummeret er aldri med; bare en maskert form.
 *
 * <p>Ferdig definert — du skal fylle den via {@link SoknadMapper#tilDto}.
 *
 * @param navn          fornavn og etternavn slått sammen
 * @param maskertFnr    fnr der alt unntatt de 4 siste sifrene er erstattet
 *                      med {@code *}, f.eks. {@code *******1234}
 * @param postnummer    postnummer (uendret)
 * @param manedsinntekt månedsinntekt i kroner (uendret)
 */
public record SoknadDto(String navn, String maskertFnr, String postnummer, int manedsinntekt) {}
