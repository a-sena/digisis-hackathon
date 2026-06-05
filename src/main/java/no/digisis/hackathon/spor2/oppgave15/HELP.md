# Hjelp — Oppgave 15: Prioritert saksbehandlingskø

Du skal bygge en kø der "neste sak" ikke er den som ble lagt inn først,
men den med høyest prioritet. `java.util.PriorityQueue` gir deg nettopp
dette — den henter alltid ut det minste elementet ifølge en `Comparator`.

Definér rekkefølgen slik at "minst" = "høyest prioritet":

```java
private final PriorityQueue<ForeldrepengerSoknad> ko = new PriorityQueue<>(
        Comparator.comparingInt(ForeldrepengerSoknad::manedsinntekt)
                  .thenComparingInt(ForeldrepengerSoknad::alder));
```

- `leggTil` → `ko.offer(soknad)`
- `nesteSak` → `Optional.ofNullable(ko.poll())` (`poll` fjerner OG
  returnerer hodet, eller `null` på tom kø)
- `antall` → `ko.size()`

Regelen: **lavest månedsinntekt først** (mest trengende), og ved lik
inntekt **yngst alder først**. Begge er "stigende" sammenligninger, så
`comparingInt(...).thenComparingInt(...)` treffer rett uten `.reversed()`.

Tom kø skal gi `Optional.empty()` fra `nesteSak()` — ikke kast.
