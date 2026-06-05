# Hjelp — Oppgave 2: Beregningsgrunnlag

Tre steg, i denne rekkefølgen:

1. **Snitt × 12.** Snitt av de tre månedene, ganget med 12, gir
   årssatsen som NAV regner med.
2. **Variansjekk** (hopp over hvis `aarsinntekt == 0`):
   forholdet `|årssats - aarsinntekt| / aarsinntekt`. Hvis det er
   *strengt større enn* 0.25 → returner `ManuellVurdering`. Vær
   nøye: nøyaktig 25% skal *ikke* utløse manuell vurdering.
3. **6G-cap.** Ellers: returner `Grunnlag(min(årssats, 6 × grunnbeloep))`.

Tip: bruk `double` til varians-utregningen for å unngå presisjons-
feil, og kast tilbake til `int` når du bygger `Grunnlag`-resultatet.
