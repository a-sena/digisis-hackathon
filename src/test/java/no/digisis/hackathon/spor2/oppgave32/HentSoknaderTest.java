package no.digisis.hackathon.spor2.oppgave32;

import com.sun.net.httpserver.HttpServer;
import no.digisis.hackathon.spor2.domain.Soknad;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.charset.StandardCharsets;
import java.util.List;
import java.util.Set;
import java.util.concurrent.atomic.AtomicInteger;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * Stubber begge API-ene med en lokal {@link HttpServer} (JDK-innebygd) så
 * testen er deterministisk og kjører uten nett — og uten Mod-11-logikk:
 * gyldighet bestemmes av en fast liste her, ikke av et kontrollsiffer.
 */
class HentSoknaderTest {

    private HttpServer server;
    private String baseUrl;
    private final AtomicInteger fnrKall = new AtomicInteger();

    private static final String SOKNADER_JSON = """
        [{"id":"fp-1","beskrivelse":"t","fnr":"04059012377","erNorskBorger":true,"termindato":"2026-08-15","oppgittArsinntekt":540000,"inntektshistorikk":[{"maned":"2026-01","type":"ARBEID","belop":45000}],"antallBarn":1,"rettsforhold":"begge","dekningsgrad":100},
         {"id":"fp-2","beskrivelse":"t","fnr":"13057812360","erNorskBorger":true,"termindato":"2026-08-15","oppgittArsinntekt":540000,"inntektshistorikk":[{"maned":"2026-01","type":"ARBEID","belop":45000}],"antallBarn":1,"rettsforhold":"begge","dekningsgrad":100},
         {"id":"fp-3","beskrivelse":"t","fnr":"00000000000","erNorskBorger":true,"termindato":"2026-08-15","oppgittArsinntekt":540000,"inntektshistorikk":[{"maned":"2026-01","type":"ARBEID","belop":45000}],"antallBarn":1,"rettsforhold":"begge","dekningsgrad":100},
         {"id":"fp-4","beskrivelse":"t","fnr":"11111111111","erNorskBorger":true,"termindato":"2026-08-15","oppgittArsinntekt":540000,"inntektshistorikk":[{"maned":"2026-01","type":"ARBEID","belop":45000}],"antallBarn":1,"rettsforhold":"begge","dekningsgrad":100}]
        """;
    private static final Set<String> GYLDIGE = Set.of("04059012377", "13057812360");

    @BeforeEach
    void start() throws IOException {
        server = HttpServer.create(new InetSocketAddress("localhost", 0), 0);
        server.createContext("/api/foreldrepenger/soknader", ex -> {
            byte[] b = SOKNADER_JSON.getBytes(StandardCharsets.UTF_8);
            ex.getResponseHeaders().add("Content-Type", "application/json");
            ex.sendResponseHeaders(200, b.length);
            ex.getResponseBody().write(b);
            ex.close();
        });
        server.createContext("/api/fnr", ex -> {
            fnrKall.incrementAndGet();
            String body = new String(ex.getRequestBody().readAllBytes(), StandardCharsets.UTF_8).trim();
            String fnr = body.replaceAll("^\"|\"$", ""); // fnr kommer som JSON-streng
            boolean gyldig = GYLDIGE.contains(fnr);
            byte[] b = (gyldig
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

    @Test
    void testReturnererKunGyldigeIRekkefolge() {
        List<Soknad> result = HentSoknader.hentGyldigeSoknader(baseUrl);
        assertEquals(List.of("fp-1", "fp-2"), result.stream().map(Soknad::id).toList());
    }

    @Test
    void testValidererAlleFnr() {
        HentSoknader.hentGyldigeSoknader(baseUrl);
        // ett valideringskall (POST /api/fnr) per søknad i listen (4 stk).
        assertEquals(4, fnrKall.get());
    }
}
