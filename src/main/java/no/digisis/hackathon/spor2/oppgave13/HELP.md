# Hjelp — Oppgave 13: Generisk register

En generisk klasse. `idAv` (en `Function<T, ID>`) er allerede tatt imot i
konstruktøren; du implementerer metodene. Bruk en `Map<ID, T>` — gjerne
en `LinkedHashMap` om du vil bevare innsettingsrekkefølgen:

```java
private final Map<ID, T> map = new LinkedHashMap<>();
public void leggTil(T t)        { map.put(idAv.apply(t), t); }
public Optional<T> finn(ID id)  { return Optional.ofNullable(map.get(id)); }
public List<T> hentAlle()       { return List.copyOf(map.values()); }
public int antall()             { return map.size(); }
```

Poenget med generics: samme register virker for `Person` (id = fnr),
`Integer` (id = `n % 10`), hva som helst — uten å kopiere koden.

`hentAlle()` skal returnere en **uforanderlig** kopi (`List.copyOf(...)`)
slik at den som kaller ikke kan endre registerets interne tilstand.
