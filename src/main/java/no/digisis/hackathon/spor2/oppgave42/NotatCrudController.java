package no.digisis.hackathon.spor2.oppgave42;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

/**
 * Oppgave 42 — CRUD for saksnotater (15 poeng)
 *
 * <p>En liten forvaltnings-API for saksnotater. {@code store} er seedet
 * for deg med notatene "1"/"a", "2"/"b", "3"/"c". Du implementerer to
 * endepunkter, og kontrolleren returnerer 404 <b>selv</b> (ingen global
 * feilhåndtering her):
 *
 * <ul>
 *   <li>{@code PUT /notater/{fnr}} (body: {@link Saksnotat}) → 200 med
 *       det oppdaterte notatet når fnr finnes; ellers 404 med
 *       {@code {"feil": "notat <fnr> finnes ikke"}}.</li>
 *   <li>{@code DELETE /notater/{fnr}} → 204 når notatet fantes (slett det);
 *       ellers 404 med samme feil-body.</li>
 * </ul>
 *
 * <p>Tips: returner {@code ResponseEntity.status(404).body(Map.of("feil", ...))}
 * for ikke-funnet, {@code ResponseEntity.ok(notat)} ved oppdatering og
 * {@code ResponseEntity.noContent().build()} ved sletting.
 */
@RestController
public class NotatCrudController {

    private final Map<String, Saksnotat> store = new HashMap<>();

    public NotatCrudController() {
        store.put("1", new Saksnotat("1", "a"));
        store.put("2", new Saksnotat("2", "b"));
        store.put("3", new Saksnotat("3", "c"));
    }

    @PutMapping("/notater/{fnr}")
    public ResponseEntity<?> oppdater(@PathVariable String fnr, @RequestBody Saksnotat notat) {
        // TODO: 404 hvis fnr ikke finnes, ellers oppdater og returner 200
        throw new UnsupportedOperationException("Oppgave 42 — ikke implementert ennå");
    }

    @DeleteMapping("/notater/{fnr}")
    public ResponseEntity<?> slett(@PathVariable String fnr) {
        // TODO: 404 hvis fnr ikke finnes, ellers slett og returner 204
        throw new UnsupportedOperationException("Oppgave 42 — ikke implementert ennå");
    }
}
