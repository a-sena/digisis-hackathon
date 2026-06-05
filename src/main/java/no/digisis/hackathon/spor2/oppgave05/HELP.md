# Hjelp — Oppgave 5: Les soknader fra CSV

Del problemet i tre:

1. En metode som parser én CSV-linje til feltene (fnr som `String` for
   nå; alder, postnummer og inntekt som riktige typer).
2. En metode som validerer fnr-et ved å POSTe det til
   `https://api.digisis.org/api/fnr` og leser `status`-feltet av JSON-
   svaret. Returner `true` hvis svaret er `{"status":"valid", ...}`.
3. `les(...)` som leser fila, hopper over header-linja, kjører hver
   linje gjennom (1) og (2), og bygger en `ForeldrepengerSoknad` bare
   når alt passerer. Ugyldige linjer hoppes over uten å kaste.

Eksempel-kall med `curl`:

    curl -X POST https://api.digisis.org/api/fnr \
         -H 'Content-Type: application/json' \
         -d '"01059010006"'

Verktøykasse:

- `java.net.http.HttpClient` for selve HTTP-kallet (innebygd i Java).
- Jackson sin `ObjectMapper` (allerede på classpath) for å parse JSON-
  svaret. Du trenger bare `status`-feltet.
- `Optional<T>` passer fint som returtype mellom parse-steget og
  validerings-steget.
