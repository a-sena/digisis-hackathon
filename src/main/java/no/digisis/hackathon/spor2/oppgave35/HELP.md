# Hjelp — Oppgave 35: Vedtaksmotor

En **regelmotor**: gå gjennom reglene i fast rekkefølge, og returner med
en gang et steg avgjør saken. `Vedtak` er en *sealed* sum-type med fire
varianter — bygg dem med `new Vedtak.Innvilget(grunnlag)`,
`new Vedtak.Engangsstonad()`, osv.

Bryt det ned i tre deler:

**1. Opptjening (steg 1).** Tre betingelser, alle må holde:

- `soknad.erNorskBorger()`.
- Antall *godkjente* måneder ≥ 6. Godkjent = alle inntektstyper unntatt
  `Inntektstype.STIPEND_LANEKASSEN`. Bruk en stream:

```java
var godkjent = soknad.inntektshistorikk().stream()
        .filter(i -> i.type() != Inntektstype.STIPEND_LANEKASSEN)
        .toList();
long sum = godkjent.stream().mapToLong(Inntektsregistrering::belop).sum();
double annualisert = sum * 12.0 / 10.0;
boolean opptjeningOk = soknad.erNorskBorger() && godkjent.size() >= 6 && annualisert >= HALV_G;
```

**2. Fallback (steg 1b).** Hvis opptjening *ikke* holder:
`new Vedtak.Engangsstonad()` hvis norsk borger, ellers
`new Vedtak.Avslag()`.

**3. Beregningsgrunnlag (steg 2)** — bare hvis opptjening holdt:

- Snitt av de **3 siste** elementene i `inntektshistorikk`, ganget med 12
  → `arssats`. (`list.subList(list.size() - 3, list.size())`.)
- Avvik: hvis `oppgittArsinntekt > 0` og
  `Math.abs(arssats - oppgittArsinntekt) / (double) oppgittArsinntekt > 0.25`
  → `new Vedtak.ManuellVurdering()`.
- Ellers `grunnlag = Math.min(arssats, SEKS_G)` →
  `new Vedtak.Innvilget(grunnlag)`.

Tips: returner tidlig fra hvert steg. Husk heltallsdeling — bruk `double`
i annualiserings- og avviksregningen.
