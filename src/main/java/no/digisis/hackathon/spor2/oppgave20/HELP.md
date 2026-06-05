# Hjelp — Oppgave 20: GET /soknader

Din første Spring-kontroller. Registeret (fra oppgave 12) er allerede
injisert i konstruktøren — du skal bare returnere innholdet.

- `@GetMapping("/soknader")` er allerede satt opp.
- Spør registeret om alle søknadene og returner lista. Spring
  serialiserer den til JSON for deg — du trenger ikke gjøre noe med
  JSON selv her (det gjorde du for hånd i oppgave 16).
- Testen bruker `MockMvc` og forventer `200 OK` med tre elementer
  (demodataene seedes ved oppstart).
