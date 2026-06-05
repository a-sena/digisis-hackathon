# Hjelp — Oppgave 36: Vedtaksbrev

Oversett et `Vedtak` (sum-typen fra oppgave 35) til én setning per
utfall. Importér typen:

```java
import no.digisis.hackathon.spor2.oppgave35.Vedtak;
```

Bruk en **uttømmende** `switch` med pattern matching. Siden `Vedtak` er
`sealed`, dekker `switch` alle fire variantene uten en `default`-gren —
og kompilatoren stopper deg om du glemmer en:

```java
return switch (vedtak) {
    case Vedtak.Innvilget i -> "Søknaden er innvilget med et grunnlag på " + i.grunnlag() + " kr.";
    case Vedtak.Engangsstonad e -> "Du får engangsstønad.";
    case Vedtak.Avslag a -> "Søknaden er avslått.";
    case Vedtak.ManuellVurdering m -> "Saken går til manuell vurdering.";
};
```

Pass på at tekstene er nøyaktig som i Javadoc — testene sammenligner
streng for streng. For `Innvilget` skal selve grunnlaget (tallet) være
en del av setningen.
