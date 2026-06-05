# Hjelp — Oppgave 14: Trådsikkert register

Et register som flere tråder skriver til samtidig. Med en vanlig
`HashMap` kan to samtidige `put`-kall tråkke på hverandre — skrivinger
forsvinner, eller mappet havner i en korrupt tilstand. Løsningen er en
datastruktur bygget for samtidighet: `java.util.concurrent.ConcurrentHashMap`.

```java
private final Map<Fodselsnummer, ForeldrepengerSoknad> map = new ConcurrentHashMap<>();
public void leggTil(ForeldrepengerSoknad s) { map.put(s.fnr(), s); }
public Optional<ForeldrepengerSoknad> finn(Fodselsnummer fnr) { return Optional.ofNullable(map.get(fnr)); }
public int antall() { return map.size(); }
```

Testen kjører `IntStream.range(0, N).parallel().forEach(...)` — altså
mange samtidige `leggTil`-kall med distinkte fnr — og forventer at
`antall()` til slutt er nøyaktig `N`. Med en `ConcurrentHashMap` holder
det; med en `HashMap` vil du før eller siden miste skrivinger.

## Språkforskjell (Java vs. TypeScript)

Java kjører faktisk flere tråder i parallell, så delt muterbar tilstand
må være trådsikker. **Node.js er enkelt-trådet** — JavaScript-kallback
kjører én om gangen på event-loopen, så et vanlig `Map` mister ikke
skrivinger selv under samtidige `await`-kall. TypeScript-varianten av
denne oppgaven viser samme invariant (ingen tapte oppdateringer under
`Promise.all`), men trenger ingen spesiell trådsikker datastruktur.
