# Hjelp — Oppgave 23: Status, headers og ResponseEntity

`ResponseEntity` lar deg sette tre ting i ett: status, headere og body.

1. Start med `ResponseEntity.ok()` for 200.
2. Legg på en custom header med `.header("X-Total-Count", ...)` — verdien
   må være en streng, så konverter tallet med `String.valueOf(...)`.
3. Avslutt med `.body(...)`. En liten `Map.of("antall", n)` blir til
   JSON-kroppen `{"antall": n}` automatisk.

`register.antall()` gir deg tallet du trenger både til headeren og bodyen.
