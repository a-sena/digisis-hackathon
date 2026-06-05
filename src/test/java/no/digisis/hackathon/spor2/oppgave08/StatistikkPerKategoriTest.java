package no.digisis.hackathon.spor2.oppgave08;

import no.digisis.hackathon.spor2.domain.Fodselsnummer;
import no.digisis.hackathon.spor2.domain.ForeldrepengerSoknad;
import no.digisis.hackathon.spor2.domain.Inntektskategori;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;

class StatistikkPerKategoriTest {

    private static ForeldrepengerSoknad soknad(int lonn) {
        return new ForeldrepengerSoknad(
                Fodselsnummer.av("01059010006"),
                "Test", "Person", 30, "0560", lonn);
    }

    @Test
    void testTomListeGirTomMap() {
        Map<Inntektskategori, StatistikkPerKategori.Statistikk> resultat =
                StatistikkPerKategori.beregn(List.of());
        assertEquals(0, resultat.size());
    }

    @Test
    void testKunLav() {
        var soknader = List.of(soknad(20_000), soknad(25_000));
        var resultat = StatistikkPerKategori.beregn(soknader);
        assertEquals(1, resultat.size());
        assertEquals(2L, resultat.get(Inntektskategori.LAV).antall());
        assertEquals(22_500.0, resultat.get(Inntektskategori.LAV).snittInntekt());
    }

    @Test
    void testBlandetGruppe() {
        var soknader = List.of(
                soknad(20_000),  // LAV
                soknad(40_000),  // MIDDELS
                soknad(50_000),  // MIDDELS
                soknad(80_000)   // HOY
        );
        var resultat = StatistikkPerKategori.beregn(soknader);
        assertEquals(3, resultat.size());
        assertEquals(1L, resultat.get(Inntektskategori.LAV).antall());
        assertEquals(2L, resultat.get(Inntektskategori.MIDDELS).antall());
        assertEquals(1L, resultat.get(Inntektskategori.HOY).antall());
        assertEquals(45_000.0, resultat.get(Inntektskategori.MIDDELS).snittInntekt());
    }
}
