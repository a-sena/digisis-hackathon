# Hjelp — Oppgave 22: GET /soknader/filter med to query-parametere

Annotasjonene for query-param er allerede på plass i metode-signaturen,
med fornuftige default-verdier:

- `minInntekt` defaulter til `0` (slipper alle gjennom).
- `maxAlder` defaulter til `Integer.MAX_VALUE` (slipper alle gjennom).

Slik betyr "manglende parameter" automatisk "ingen begrensning".

Filtrer `register.hentAlle()` på begge kriteriene samtidig
(`manedsinntekt() >= minInntekt` OG `alder() <= maxAlder`). En `stream()`
med to `.filter(...)` er den ryddigste måten.

Test fra terminal:

    curl "http://localhost:8080/soknader/filter?minInntekt=30000&maxAlder=34"
