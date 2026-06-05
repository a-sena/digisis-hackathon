package no.digisis.hackathon.spor2.oppgave14;

import no.digisis.hackathon.spor2.domain.Fodselsnummer;
import no.digisis.hackathon.spor2.domain.ForeldrepengerSoknad;
import org.junit.jupiter.api.Test;

import java.util.stream.IntStream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class TradsikkertRegisterTest {

    private static final int N = 1_000;

    private static Fodselsnummer fnr(int i) {
        return Fodselsnummer.av(String.format("%011d", i));
    }

    private static ForeldrepengerSoknad soknad(int i, int lonn) {
        return new ForeldrepengerSoknad(fnr(i), "Test", "Person", 30, "0560", lonn);
    }

    @Test
    void testParallellInnsettingGirAntallN() {
        var register = new TradsikkertRegister();
        IntStream.range(0, N).parallel().forEach(i -> register.leggTil(soknad(i, 25_000)));
        assertEquals(N, register.antall());
    }

    @Test
    void testDistinkteNoklerBevares() {
        var register = new TradsikkertRegister();
        IntStream.range(0, N).parallel().forEach(i -> register.leggTil(soknad(i, 25_000)));
        // Hver nøkkel skal kunne slås opp etterpå.
        boolean alleFinnes = IntStream.range(0, N).allMatch(i -> register.finn(fnr(i)).isPresent());
        assertTrue(alleFinnes);
    }

    @Test
    void testOverskriverSammeNokkelEnGang() {
        var register = new TradsikkertRegister();
        register.leggTil(soknad(7, 25_000));
        register.leggTil(soknad(7, 30_000)); // samme fnr → overskriver
        assertEquals(1, register.antall());
        assertEquals(30_000, register.finn(fnr(7)).orElseThrow().manedsinntekt());
    }

    @Test
    void testOppslagEtterSamtidigInnsetting() {
        var register = new TradsikkertRegister();
        IntStream.range(0, N).parallel().forEach(i -> register.leggTil(soknad(i, i)));
        assertEquals(42, register.finn(fnr(42)).orElseThrow().manedsinntekt());
    }
}
