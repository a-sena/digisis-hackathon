# Hjelp — Oppgave 44: Idempotent oppdatering + audit

To `Map`-er er felt på kontrolleren: `store` (id → siste journal) og
`skrivinger` (id → antall skrivinger). PUT-en gjør tre ting:

```java
store.put(id, journal);
int n = skrivinger.merge(id, 1, Integer::sum);
return ResponseEntity.ok().header("X-Skrivinger", String.valueOf(n)).body(store.get(id));
```

- **Idempotent state**: skriver du samme body to ganger, er den lagrede
  verdien identisk begge ganger — `store.put` overskriver bare.
- **Audit**: `merge(id, 1, Integer::sum)` setter telleren til 1 første
  gang og øker den med 1 hver påfølgende gang, og returnerer den nye
  verdien — perfekt for `X-Skrivinger`-headeren.
- Headeren er en streng, så bruk `String.valueOf(n)`.
