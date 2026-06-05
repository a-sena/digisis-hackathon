package no.digisis.hackathon.spor2.oppgave33;

import com.sun.net.httpserver.HttpServer;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.charset.StandardCharsets;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * Stubber {@code /api/fnr} med en lokal {@link HttpServer} (JDK-innebygd).
 * Hver «variant» får sin egen sti-prefiks slik at vi kan teste gyldig,
 * ugyldig, treg (timeout), og 500 mot samme server — pluss en nettfeil
 * mot en port der ingen server lytter.
 */
class RobustFnrKlientTest {

    private HttpServer server;
    private String baseUrl;
    private int dodPort;

    private static void svar(com.sun.net.httpserver.HttpExchange ex, int kode, String body) throws IOException {
        byte[] b = body.getBytes(StandardCharsets.UTF_8);
        ex.getResponseHeaders().add("Content-Type", "application/json");
        ex.sendResponseHeaders(kode, b.length);
        ex.getResponseBody().write(b);
        ex.close();
    }

    @BeforeEach
    void start() throws IOException {
        server = HttpServer.create(new InetSocketAddress("localhost", 0), 0);
        server.createContext("/gyldig/api/fnr", ex -> svar(ex, 200, "{\"status\":\"valid\"}"));
        server.createContext("/ugyldig/api/fnr", ex -> svar(ex, 200, "{\"status\":\"invalid\"}"));
        server.createContext("/treg/api/fnr", ex -> {
            try {
                Thread.sleep(600); // lengre enn klientens 300ms-timeout
            } catch (InterruptedException ignored) {
                Thread.currentThread().interrupt();
            }
            svar(ex, 200, "{\"status\":\"valid\"}");
        });
        server.createContext("/feil/api/fnr", ex -> svar(ex, 500, "{\"feil\":\"serverfeil\"}"));
        server.start();
        int port = server.getAddress().getPort();
        baseUrl = "http://localhost:" + port;

        // Finn en ledig port og lukk den igjen — der lytter ingen, så et
        // kall dit gir en ekte tilkoblingsfeil.
        HttpServer doer = HttpServer.create(new InetSocketAddress("localhost", 0), 0);
        dodPort = doer.getAddress().getPort();
        doer.stop(0);
    }

    @AfterEach
    void stop() {
        server.stop(0);
    }

    @Test
    void testGyldig() {
        assertEquals(Status.GYLDIG, RobustFnrKlient.valider("04059012377", baseUrl + "/gyldig"));
    }

    @Test
    void testUgyldig() {
        assertEquals(Status.UGYLDIG, RobustFnrKlient.valider("00000000000", baseUrl + "/ugyldig"));
    }

    @Test
    void testTregGirUkjent() {
        assertEquals(Status.UKJENT, RobustFnrKlient.valider("04059012377", baseUrl + "/treg"));
    }

    @Test
    void test500GirUkjent() {
        assertEquals(Status.UKJENT, RobustFnrKlient.valider("04059012377", baseUrl + "/feil"));
    }

    @Test
    void testTilkoblingsfeilGirUkjent() {
        assertEquals(Status.UKJENT, RobustFnrKlient.valider("04059012377", "http://localhost:" + dodPort));
    }
}
