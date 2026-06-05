package no.digisis.hackathon.spor2.oppgave44;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

/**
 * Oppgave 44 — Idempotent oppdatering + audit (15 poeng)
 *
 * <p>{@code PUT /journal/{id}} (body: {@link Journal}) lagrer
 * journaloppforingen i {@code store} og teller hvor mange ganger hver id
 * har blitt skrevet i {@code skrivinger}.
 *
 * <p>Oppdateringen er <b>idempotent</b> på state: skriver du samme body
 * to ganger, er den lagrede verdien identisk begge ganger. Men
 * <b>auditen</b> teller hver skriving — så svaret har en header
 * {@code X-Skrivinger} med antall skrivinger for den id-en så langt.
 *
 * <ul>
 *   <li>Lagre {@code journal} i {@code store} under {@code id}.</li>
 *   <li>Øk skrive-telleren for {@code id} med 1.</li>
 *   <li>Returner 200 med den lagrede verdien som body og
 *       {@code X-Skrivinger: <antall>} som header.</li>
 * </ul>
 *
 * <p>Tips: {@code Map.merge(id, 1, Integer::sum)} gir deg den nye
 * telleren, og {@code ResponseEntity.ok().header(...).body(...)} setter
 * header + body samtidig.
 */
@RestController
public class JournalController {

    private final Map<String, Journal> store = new HashMap<>();
    private final Map<String, Integer> skrivinger = new HashMap<>();

    @PutMapping("/journal/{id}")
    public ResponseEntity<Journal> skriv(@PathVariable String id, @RequestBody Journal journal) {
        // TODO: lagre i store, øk skrivinger, returner 200 + X-Skrivinger
        throw new UnsupportedOperationException("Oppgave 44 — ikke implementert ennå");
    }
}
