# Hjelp — Oppgave 38: Batch-saksflyt

Kjør hele bunken med søknader gjennom vedtaksmotoren fra oppgave 35 og
sorter **søknadene** (ikke vedtakene) i fire bøtter etter utfallet.

Importér motoren og sum-typen:

```java
import no.digisis.hackathon.spor2.oppgave35.Vedtak;
import no.digisis.hackathon.spor2.oppgave35.Vedtaksmotor;
```

Bygg fire lister, løp gjennom inn-lista i rekkefølge, og legg hver
søknad i lista som svarer til vedtakets variant. Pattern matching i en
`switch` gjør plasseringen uttømmende:

```java
var innvilget = new ArrayList<Soknad>();
var engangsstonad = new ArrayList<Soknad>();
var avslag = new ArrayList<Soknad>();
var manuell = new ArrayList<Soknad>();
for (Soknad s : soknader) {
    switch (Vedtaksmotor.vurder(s)) {
        case Vedtak.Innvilget i -> innvilget.add(s);
        case Vedtak.Engangsstonad e -> engangsstonad.add(s);
        case Vedtak.Avslag a -> avslag.add(s);
        case Vedtak.ManuellVurdering m -> manuell.add(s);
    }
}
return new Saksflytresultat(innvilget, engangsstonad, avslag, manuell);
```

Siden du legger til i rekkefølge, bevares rekkefølgen innen hver bøtte
automatisk. Tom inn-liste gir fire tomme lister.
