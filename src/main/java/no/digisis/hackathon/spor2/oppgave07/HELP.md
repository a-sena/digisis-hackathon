# Hjelp — Oppgave 7: Les NDJSON tolerant

NDJSON er én JSON-verdi per linje — her én `Soknad` per linje. Mål:
les alle gyldige, hopp over blanke og råtne linjer uten å kaste.

Steg:

1. Splitt teksten på linjeskift (`tekst.split("\n", -1)`).
2. For hver linje:
   - Hopp over hvis den er blank (`linje.isBlank()`).
   - Ellers prøv å parse den med Jackson:
     `mapper.readValue(linje, Soknad.class)`.
   - Pakk parsingen i `try/catch`. Hvis den kaster (ugyldig JSON), hopp
     over linja og fortsett.
3. Samle de gyldige i en liste, i samme rekkefølge, og returner den.

Tips:

- Lag én `ObjectMapper` og gjenbruk den. `Soknad` er en `record`, og
  Jackson bygger den via konstruktøren.
- Et bredt `catch (Exception e)` er greit her — vi bryr oss ikke om
  *hvorfor* en linje er ugyldig, bare at den hoppes over.
