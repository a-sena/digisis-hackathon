# Hjelp — Oppgave 30: Komponerte tjenester

Her komponerer `BeregningService` TO samarbeidspartnere som begge
injiseres via konstruktøren:

- `SoknadsRegister` — gir deg dataene.
- `GrunnbelopKilde` — gir deg grunnbeløpet (`gKilde.grunnbelop()`).

Begge er ferdige; `GrunnbelopKilde` er en `@Component` du ikke skal røre.

Du skal fylle inn to ting:

1. `BeregningService.andelAvG(fnr)`:
   - slå opp soknaden (`register.finn(Fodselsnummer.av(fnr))`),
   - regn ut `manedsinntekt × 12 × 100 / G` (heltallsdivisjon),
   - returner `-1` hvis ingen treff.
2. `BeregningController.beregn(fnr)`: deleger til tjenesten.

Heltallsdivisjon avrunder nedover — det er meningen her.
