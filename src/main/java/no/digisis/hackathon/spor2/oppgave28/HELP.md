# Hjelp — Oppgave 28: Tjenestelag og dependency injection

Her er to lag som henger sammen:

- `VurderingController` (web-laget) injiserer `VurderingService`.
- `VurderingService` (forretningslaget, et `@Service`) injiserer
  `SoknadsRegister`.

Spring kobler alt sammen for deg via konstruktørene — du trenger bare
fylle inn logikken.

1. I `VurderingController.vurder(...)`: deleger til `service.vurder(fnr)`
   og returner resultatet. Kontrolleren skal være tynn.
2. I `VurderingService.vurder(...)`: slå opp soknaden
   (`register.finn(Fodselsnummer.av(fnr))`) og returner
   - `"berettiget"` når månedsinntekt < 35 000,
   - `"ikke berettiget"` når månedsinntekt ≥ 35 000,
   - `"ukjent"` når ingen treff finnes.

`Optional.map(...).orElse(...)` gjør de tre tilfellene elegante.
