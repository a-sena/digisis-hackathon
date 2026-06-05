# Hjelp — Oppgave 43: Paginering & sortering

`store` (en `Map<String, Saksnotat>`) er seedet for deg med "1", "2" og
"3". Spring binder `?side=` og `?storrelse=` til parametrene dine, med
`defaultValue` for når de mangler.

Mønsteret:

```java
List<Saksnotat> alle = store.values().stream()
        .sorted(Comparator.comparing(Saksnotat::fnr))
        .toList();
List<Saksnotat> innhold = alle.stream()
        .skip((long) side * storrelse)
        .limit(storrelse)
        .toList();
return new Side(side, storrelse, alle.size(), innhold);
```

- Sortér **alltid** på `fnr` før du paginerer (`Map` har ingen
  garantert rekkefølge).
- `totalt` er antallet *før* paginering (`alle.size()`).
- `skip` + `limit` håndterer kanttilfellene (en side utenfor lista gir
  bare en tom `innhold`).
