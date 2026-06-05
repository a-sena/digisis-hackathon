# Hjelp — Oppgave 26: Sentralisert feilhåndtering

`SakController` er ferdig og kaster `SakIkkeFunnet` for ukjente saker.
Jobben din er å oversette den exceptionen til et `404`-svar ett sted —
i `FeilHandtering` — i stedet for `try/catch` i hver kontroller.

- Legg til en metode med `@ExceptionHandler(SakIkkeFunnet.class)`.
- Returner `ResponseEntity.status(404).body(...)` med en liten kropp som
  inneholder feilmeldingen, f.eks. `Map.of("feil", e.getMessage())`.
- Håndter **kun** `SakIkkeFunnet` her — ikke en bred `Exception` — slik
  at adviceen ikke blander seg i andre oppgaver.

(I TypeScript-versjonen er dette `app.onError(...)`.)
