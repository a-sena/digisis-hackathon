# Hjelp — Oppgave 10: Partisjonering & oppsummering

Du skal dele soknadene i nøyaktig to bøtter etter ett ja/nei-kriterium,
og samtidig oppsummere hver bøtte.

`Collectors.partitioningBy(predikat, downstream)` er laget for akkurat
dette: den returnerer et `Map<Boolean, R>` med en `true`- og en
`false`-nøkkel — begge er alltid med, også når den ene er tom.

For å få både antall og sum i samme pass kan du kombinere flere
collectorer. Et vanlig grep er `Collectors.teeing(...)` (to downstream-
collectorer flettet sammen), eventuelt to separate `partitioningBy`-kall.

Predikatet er: `alder >= 18 && alder <= 67 && manedsinntekt < 35_000`.

Husk at en tom inputliste fortsatt skal gi en `Partisjon` med 0 på alle
fire feltene — ikke kast.
