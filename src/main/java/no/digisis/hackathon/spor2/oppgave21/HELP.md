# Hjelp — Oppgave 21: GET /soknader/{fnr}

To ting:

1. Hent fnr fra URL-en — annotasjonen er allerede på parameteret.
2. Returner enten 200 med soknaden (hvis funnet) eller 404 (hvis ikke).

For å sette ulik status-kode trenger du en respons-type som lar deg
kontrollere både status og body. Slå opp Spring sin standard for det
(`ResponseEntity`).

`register.finn(...)` tar et `Fodselsnummer` og gir deg et `Optional` —
da kan du mappe treffet til 200 og bruke `orElseGet(...)` for 404.

Hvis konvertering av fnr-strengen kaster en exception (ugyldig format),
returnerer Spring en 500 Internal Server Error — det er greit for denne
oppgaven.
