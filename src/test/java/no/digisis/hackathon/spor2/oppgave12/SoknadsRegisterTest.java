package no.digisis.hackathon.spor2.oppgave12;

import no.digisis.hackathon.spor2.domain.Fodselsnummer;
import no.digisis.hackathon.spor2.domain.ForeldrepengerSoknad;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SoknadsRegisterTest {

    private static ForeldrepengerSoknad soknad(String fnr, String navn, int lonn) {
        return new ForeldrepengerSoknad(Fodselsnummer.av(fnr), navn, "Etternavn", 30, "0560", lonn);
    }

    @Test
    void testLeggTilOgFinn() {
        var register = new SoknadsRegister();
        var aisha = soknad("01059010006", "Aisha", 25_000);
        register.leggTil(aisha);
        assertEquals(aisha, register.finn(Fodselsnummer.av("01059010006")).orElseThrow());
    }

    @Test
    void testFinnReturnererTomtNarUkjent() {
        var register = new SoknadsRegister();
        assertTrue(register.finn(Fodselsnummer.av("15079220008")).isEmpty());
    }

    @Test
    void testLeggTilOverskriverSammeFnr() {
        var register = new SoknadsRegister();
        register.leggTil(soknad("01059010006", "Aisha", 25_000));
        register.leggTil(soknad("01059010006", "Aisha", 30_000));
        assertEquals(1, register.antall());
        assertEquals(30_000, register.finn(Fodselsnummer.av("01059010006"))
                .orElseThrow().manedsinntekt());
    }

    @Test
    void testAlleErUforanderlig() {
        var register = new SoknadsRegister();
        register.leggTil(soknad("01059010006", "Aisha", 25_000));
        var alle = register.hentAlle();
        assertThrows(
                UnsupportedOperationException.class,
                () -> alle.add(soknad("15079220008", "Lin", 25_000)));
    }
}
