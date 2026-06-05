# Hjelp — Oppgave 3: Pengebeløp som verdiobjekt

Et `record Beloep(int kroner)` er allerede gitt. Du skal fylle inn
fire metoder. Alle skal returnere et *nytt* `Beloep` — aldri endre
det eksisterende (records er uforanderlige uansett).

1. **`av(int kroner)`** — fabrikkmetode. Avvis negative beløp med
   `throw new IllegalArgumentException(...)`. Ellers `new Beloep(kroner)`.
2. **`pluss(Beloep annet)`** — `av(this.kroner() + annet.kroner())`.
3. **`prosentAv(int prosent)`** — `kroner * prosent / 100`. Husk at
   heltallsdivisjon i Java kapper desimaler; det er meningen her.
4. **`kapp(Beloep tak)`** — returner det minste av de to. `Math.min`
   på `kroner`-feltene, pakk resultatet i et `Beloep`.

Tips: la `pluss`, `prosentAv` og `kapp` gå via `av(...)` — da arver de
gratis valideringen mot negative beløp.

To `Beloep` med samme `kroner` er like (`equals`) fordi `record`
genererer `equals`/`hashCode` for deg. Testene sammenligner med
`assertEquals(Beloep.av(150), ...)`.
