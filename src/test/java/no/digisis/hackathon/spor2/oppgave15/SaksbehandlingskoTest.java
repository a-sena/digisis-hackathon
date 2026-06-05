package no.digisis.hackathon.spor2.oppgave15;

import no.digisis.hackathon.spor2.domain.Fodselsnummer;
import no.digisis.hackathon.spor2.domain.ForeldrepengerSoknad;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class SaksbehandlingskoTest {

    private static ForeldrepengerSoknad soknad(String etternavn, int alder, int lonn) {
        return new ForeldrepengerSoknad(
                Fodselsnummer.av("01059010006"),
                "Test", etternavn, alder, "0560", lonn);
    }

    @Test
    void testTomKoGirEmpty() {
        var ko = new Saksbehandlingsko();
        assertTrue(ko.nesteSak().isEmpty());
    }

    @Test
    void testEnkeltSak() {
        var ko = new Saksbehandlingsko();
        var a = soknad("A", 30, 25_000);
        ko.leggTil(a);
        assertEquals(a, ko.nesteSak().orElseThrow());
    }

    @Test
    void testLavestInntektForst() {
        var ko = new Saksbehandlingsko();
        ko.leggTil(soknad("Hoy", 30, 50_000));
        ko.leggTil(soknad("Lav", 30, 20_000));
        assertEquals("Lav", ko.nesteSak().orElseThrow().etternavn());
    }

    @Test
    void testLikInntektYngstForst() {
        var ko = new Saksbehandlingsko();
        ko.leggTil(soknad("Eldre", 45, 30_000));
        ko.leggTil(soknad("Yngre", 25, 30_000));
        assertEquals("Yngre", ko.nesteSak().orElseThrow().etternavn());
    }

    @Test
    void testNesteSakTommerIRekkefolge() {
        var ko = new Saksbehandlingsko();
        ko.leggTil(soknad("B", 30, 30_000));
        ko.leggTil(soknad("A", 30, 20_000));
        ko.leggTil(soknad("C", 30, 40_000));
        assertEquals("A", ko.nesteSak().orElseThrow().etternavn());
        assertEquals("B", ko.nesteSak().orElseThrow().etternavn());
        assertEquals("C", ko.nesteSak().orElseThrow().etternavn());
        assertTrue(ko.nesteSak().isEmpty());
    }

    @Test
    void testAntallSynker() {
        var ko = new Saksbehandlingsko();
        ko.leggTil(soknad("A", 30, 20_000));
        ko.leggTil(soknad("B", 30, 30_000));
        assertEquals(2, ko.antall());
        ko.nesteSak();
        assertEquals(1, ko.antall());
    }
}
