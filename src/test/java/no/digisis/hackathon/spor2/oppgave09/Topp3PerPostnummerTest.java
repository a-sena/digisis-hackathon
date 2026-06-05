package no.digisis.hackathon.spor2.oppgave09;

import no.digisis.hackathon.spor2.domain.Fodselsnummer;
import no.digisis.hackathon.spor2.domain.ForeldrepengerSoknad;

import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;

class Topp3PerPostnummerTest {

    private static ForeldrepengerSoknad soknad(String etternavn, String postnummer, int lonn) {
        return new ForeldrepengerSoknad(
                Fodselsnummer.av("01059010006"),
                "Test", etternavn, 30, postnummer, lonn);
    }

    @Test
    void test1Sak() {
        var resultat = Topp3PerPostnummer.finn(List.of(soknad("Berg", "0560", 25_000)));
        assertEquals(List.of(25_000),
                resultat.get("0560").stream().map(ForeldrepengerSoknad::manedsinntekt).toList());
    }

    @Test
    void test3SakerSorteresFallende() {
        var soknader = List.of(
                soknad("A", "0560", 30_000),
                soknad("B", "0560", 50_000),
                soknad("C", "0560", 40_000)
        );
        Map<String, List<ForeldrepengerSoknad>> resultat = Topp3PerPostnummer.finn(soknader);
        assertEquals(List.of(50_000, 40_000, 30_000),
                resultat.get("0560").stream().map(ForeldrepengerSoknad::manedsinntekt).toList());
    }

    @Test
    void testMer3SakerKuttesTil3() {
        var soknader = List.of(
                soknad("A", "0560", 30_000),
                soknad("B", "0560", 50_000),
                soknad("C", "0560", 40_000),
                soknad("D", "0560", 60_000),
                soknad("E", "0560", 20_000)
        );
        var resultat = Topp3PerPostnummer.finn(soknader);
        assertEquals(List.of(60_000, 50_000, 40_000),
                resultat.get("0560").stream().map(ForeldrepengerSoknad::manedsinntekt).toList());
    }

    @Test
    void testToPostnummer() {
        var soknader = List.of(
                soknad("A", "0560", 50_000),
                soknad("B", "0250", 70_000),
                soknad("C", "0250", 30_000)
        );
        var resultat = Topp3PerPostnummer.finn(soknader);
        assertEquals(2, resultat.size());
        assertEquals(1, resultat.get("0560").size());
        assertEquals(2, resultat.get("0250").size());
        assertEquals(70_000, resultat.get("0250").get(0).manedsinntekt());
    }
}
