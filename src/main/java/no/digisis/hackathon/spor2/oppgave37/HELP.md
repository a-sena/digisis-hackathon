# Hjelp — Oppgave 37: Aggregert vedtaksrapport

En aggregering over en liste `Vedtak` (sum-typen fra oppgave 35).
Importér typen:

```java
import no.digisis.hackathon.spor2.oppgave35.Vedtak;
```

Start en teller for **alle fire** statuser på 0, løp gjennom vedtakene
én gang, og bruk pattern matching for å håndtere variantene uttømmende:

```java
var antall = new HashMap<String, Integer>();
for (String s : List.of("INNVILGET", "ENGANGSSTONAD", "AVSLAG", "MANUELL_VURDERING")) antall.put(s, 0);
long total = 0; int n = 0;
for (Vedtak v : vedtak) {
    String status = switch (v) {
        case Vedtak.Innvilget i -> { total += i.grunnlag(); n++; yield "INNVILGET"; }
        case Vedtak.Engangsstonad e -> "ENGANGSSTONAD";
        case Vedtak.Avslag a        -> "AVSLAG";
        case Vedtak.ManuellVurdering m -> "MANUELL_VURDERING";
    };
    antall.merge(status, 1, Integer::sum);
}
long snitt = n == 0 ? 0 : Math.round((double) total / n);
```

- Husk at alle fire nøkler skal være med selv om en status ikke
  forekommer (verdi 0).
- `snittGrunnlagInnvilget` rundes til nærmeste heltall med `Math.round`,
  og er 0 når ingen er innvilget.

(`switch` over en `sealed` type er uttømmende — kompilatoren klager hvis
du glemmer en variant.)
