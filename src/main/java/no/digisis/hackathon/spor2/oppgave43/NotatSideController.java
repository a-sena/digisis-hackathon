package no.digisis.hackathon.spor2.oppgave43;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

/**
 * Oppgave 43 — Paginering & sortering (15 poeng)
 *
 * <p>{@code store} er seedet for deg med notatene "1", "2" og "3". Du
 * implementerer ett endepunkt:
 *
 * <ul>
 *   <li>{@code GET /notater?side=0&storrelse=10} → 200 med en {@link Side}.
 *       Sortér notatene på {@code fnr} (stigende), del dem opp i sider på
 *       {@code storrelse} og returner siden {@code side}. Default
 *       {@code side = 0}, {@code storrelse = 10}. {@code totalt} er det
 *       totale antallet notater (før paginering).</li>
 * </ul>
 *
 * <p>Tips: sortér en kopi av {@code store.values()} på {@code fnr}, og
 * bruk {@code subList}/{@code stream().skip(...).limit(...)} for å hente
 * ut siden. Pass på å ikke gå utenfor lista.
 */
@RestController
public class NotatSideController {

    private final Map<String, Saksnotat> store = new HashMap<>();

    public NotatSideController() {
        store.put("1", new Saksnotat("1", "a"));
        store.put("2", new Saksnotat("2", "b"));
        store.put("3", new Saksnotat("3", "c"));
    }

    @GetMapping("/notater")
    public Side hent(@RequestParam(defaultValue = "0") int side,
                     @RequestParam(defaultValue = "10") int storrelse) {
        // TODO: sortér på fnr, paginer (side/storrelse), returner Side
        throw new UnsupportedOperationException("Oppgave 43 — ikke implementert ennå");
    }
}
