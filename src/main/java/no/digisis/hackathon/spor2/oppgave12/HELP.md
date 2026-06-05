# Hjelp — Oppgave 12: In-memory søknadsregister

Et register er bare en innkapslet datastruktur med fire operasjoner.

- Velg en `Map` med rask oppslag på fnr — `Fodselsnummer` er en record,
  så den funker fint som nøkkel (`equals`/`hashCode` er gratis).
- `leggTil` skal *overskrive* ved samme fnr — det er nettopp det
  `map.put(...)` gjør.
- `finn` returnerer `Optional` — bruk `Optional.ofNullable(map.get(fnr))`.
- `hentAlle` skal være *uforanderlig*. `List.copyOf(map.values())` gir
  en liste som kaster `UnsupportedOperationException` hvis noen prøver å
  endre den — som testen forventer.
