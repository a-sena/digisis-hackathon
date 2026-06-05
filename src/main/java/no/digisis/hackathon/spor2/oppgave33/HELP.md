# Hjelp — Oppgave 33: Robust HTTP-klient: timeout & fallback

Poenget her er feilhåndtering, ikke selve kallet. En tjeneste i en større
kjede skal ikke krasje fordi ett eksternt API henger eller svarer rart.

**Kort timeout** på selve forespørselen:

```java
HttpRequest req = HttpRequest.newBuilder(URI.create(baseUrl + "/api/fnr"))
        .timeout(Duration.ofMillis(300))
        .header("Content-Type", "application/json")
        .POST(HttpRequest.BodyPublishers.ofString(mapper.writeValueAsString(fnr)))
        .build();
```

**Pakk alt i én `try/catch`.** `client.send(...)` kaster `IOException` og
`HttpTimeoutException` (en `IOException`) — fang dem (og gjerne alt annet)
og returner `Status.UKJENT`. Da slipper en treg eller død tjeneste gjennom
som et tydelig «vet ikke», ikke en exception.

**Tolk svaret:**

```java
if (res.statusCode() != 200) return Status.UKJENT;
String status = mapper.readTree(res.body()).path("status").asText();
return switch (status) {
    case "valid"   -> Status.GYLDIG;
    case "invalid" -> Status.UGYLDIG;
    default        -> Status.UKJENT;
};
```

Ingen lokal Mod-11 — `status`-feltet fra API-et avgjør GYLDIG/UGYLDIG.
