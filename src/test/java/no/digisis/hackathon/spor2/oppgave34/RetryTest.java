package no.digisis.hackathon.spor2.oppgave34;

import org.junit.jupiter.api.Test;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.function.Supplier;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class RetryTest {

    @Test
    void testLykkesForsteForsok() {
        AtomicInteger kall = new AtomicInteger();
        String resultat = Retry.medRetry(() -> {
            kall.incrementAndGet();
            return "ok";
        }, 3);
        assertEquals("ok", resultat);
        assertEquals(1, kall.get()); // ingen retry når første forsøk lykkes
    }

    @Test
    void testFeiler2GangerSaaLykkes() {
        AtomicInteger kall = new AtomicInteger();
        Supplier<String> kalle = () -> {
            if (kall.incrementAndGet() < 3) {
                throw new RuntimeException("midlertidig feil");
            }
            return "ok";
        };
        assertEquals("ok", Retry.medRetry(kalle, 3));
        assertEquals(3, kall.get());
    }

    @Test
    void testAlltidFeilerKasterEtter2Forsok() {
        AtomicInteger kall = new AtomicInteger();
        RuntimeException kastet = assertThrows(RuntimeException.class, () ->
                Retry.medRetry(() -> {
                    kall.incrementAndGet();
                    throw new RuntimeException("feil " + kall.get());
                }, 2));
        assertEquals(2, kall.get());
        assertEquals("feil 2", kastet.getMessage()); // det SISTE unntaket kastes videre
    }

    @Test
    void test1ForsokOgFeilKaster() {
        AtomicInteger kall = new AtomicInteger();
        assertThrows(IllegalStateException.class, () ->
                Retry.medRetry(() -> {
                    kall.incrementAndGet();
                    throw new IllegalStateException("nei");
                }, 1));
        assertEquals(1, kall.get());
    }

    @Test
    void testReturnererVerdien() {
        assertEquals(42, Retry.medRetry(() -> 42, 3));
    }
}
