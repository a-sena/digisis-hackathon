package no.digisis.hackathon.spor2.oppgave13;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

class RegisterTest {

    record Person(String fnr, String navn) {}

    @Test
    void testLeggTilOgFinn() {
        var r = new Register<Person, String>(Person::fnr);
        var aisha = new Person("1", "Aisha");
        r.leggTil(aisha);
        assertEquals(aisha, r.finn("1").orElseThrow());
    }

    @Test
    void testFinnUkjentGirTom() {
        var r = new Register<Person, String>(Person::fnr);
        assertTrue(r.finn("3").isEmpty());
    }

    @Test
    void testOverskriverSammeId() {
        var r = new Register<Person, String>(Person::fnr);
        r.leggTil(new Person("1", "Aisha"));
        r.leggTil(new Person("1", "Aisha2")); // samme id → overskriver
        assertEquals(1, r.antall());
        assertEquals("Aisha2", r.finn("1").orElseThrow().navn());
    }

    @Test
    void testHentAlleErUforanderlig() {
        var r = new Register<Person, String>(Person::fnr);
        r.leggTil(new Person("1", "Aisha"));
        var alle = r.hentAlle();
        assertThrows(
                UnsupportedOperationException.class,
                () -> alle.add(new Person("2", "Lin")));
    }

    @Test
    void testAntall() {
        var r = new Register<Person, String>(Person::fnr);
        r.leggTil(new Person("1", "A"));
        r.leggTil(new Person("2", "B"));
        assertEquals(2, r.antall());
    }
}
