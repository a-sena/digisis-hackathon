package no.digisis.hackathon.spor2.oppgave05;

import com.sun.net.httpserver.HttpServer;
import no.digisis.hackathon.spor2.domain.ForeldrepengerSoknad;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.charset.StandardCharsets;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.Objects;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * Stubber fnr-API-et med en lokal HttpServer (JDK-innebygd) så testen er
 * deterministisk og kjorer uten nett — gyldighet bestemmes av en fast
 * liste her, ikke av Mod-11.
 */
class CsvLeserTest {

    private static final Set<String> GYLDIGE = Set.of("01059010006", "15079220008", "24038815071");

    private HttpServer server;
    private String baseUrl;

    @BeforeEach
    void start() throws IOException {
        server = HttpServer.create(new InetSocketAddress("localhost", 0), 0);
        server.createContext("/api/fnr", ex -> {
            String body = new String(ex.getRequestBody().readAllBytes(), StandardCharsets.UTF_8).trim();
            String fnr = body.replaceAll("^\"|\"$", ""); // fnr kommer som JSON-streng
            byte[] b = (GYLDIGE.contains(fnr)
                    ? "{\"status\":\"valid\",\"type\":\"fnr\"}"
                    : "{\"status\":\"invalid\",\"reasons\":[\"mock\"]}").getBytes(StandardCharsets.UTF_8);
            ex.getResponseHeaders().add("Content-Type", "application/json");
            ex.sendResponseHeaders(200, b.length);
            ex.getResponseBody().write(b);
            ex.close();
        });
        server.start();
        baseUrl = "http://localhost:" + server.getAddress().getPort();
    }

    @AfterEach
    void stop() {
        server.stop(0);
    }

    private Path testfil() {
        return Paths.get(Objects.requireNonNull(
                getClass().getClassLoader().getResource("soknader.csv")).getPath());
    }

    @Test
    void testLeserKunGyldigeSaker() {
        List<ForeldrepengerSoknad> soknader = CsvLeser.les(testfil(), baseUrl);
        // 15 datalinjer; 5 er ugyldige (2 fnr avvist av API-stubben, 1
        // ikke-numerisk fnr, 1 blank fornavn, 1 negativ lonn). 10 gyldige.
        assertEquals(10, soknader.size());
    }

    @Test
    void testAlleHarKomplettenavn() {
        List<ForeldrepengerSoknad> soknader = CsvLeser.les(testfil(), baseUrl);
        assertTrue(soknader.stream().allMatch(s ->
                !s.fornavn().isBlank() && !s.etternavn().isBlank()));
    }
}
