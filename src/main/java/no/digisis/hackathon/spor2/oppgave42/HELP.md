# Hjelp — Oppgave 42: CRUD for saksnotater

`store` (en `Map<String, Saksnotat>`) er seedet for deg med "1", "2" og
"3". Her returnerer kontrolleren statuskoder **selv** — det er ingen
global feilhåndterer i denne oppgaven.

**PUT — oppdater eller 404:**

```java
if (!store.containsKey(fnr)) {
    return ResponseEntity.status(404).body(Map.of("feil", "notat " + fnr + " finnes ikke"));
}
store.put(fnr, notat);
return ResponseEntity.ok(notat);
```

**DELETE — 204 eller 404:**

```java
if (store.remove(fnr) == null) {
    return ResponseEntity.status(404).body(Map.of("feil", "notat " + fnr + " finnes ikke"));
}
return ResponseEntity.noContent().build();
```

Returtypen er `ResponseEntity<?>` siden body-en er enten et `Saksnotat`
eller et `Map` (feil), eller tom (204). `Map.remove` returnerer `null`
når nøkkelen ikke fantes — det gir deg "fantes/fantes ikke" gratis.
