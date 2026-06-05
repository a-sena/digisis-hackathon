# Hjelp — Oppgave 32: Hent & valider søknader fra API

Tre steg.

**1. Hent listen** med `HttpClient` + Jackson:

```java
HttpClient client = HttpClient.newHttpClient();
ObjectMapper mapper = new ObjectMapper();
HttpResponse<String> res = client.send(
    HttpRequest.newBuilder(URI.create(baseUrl + "/api/foreldrepenger/soknader")).GET().build(),
    HttpResponse.BodyHandlers.ofString());
List<Soknad> soknader = mapper.readValue(res.body(), new TypeReference<List<Soknad>>() {});
```

**2. Valider alle fnr — parallelt.** Den enkleste parallelle løsningen i
Java er `parallelStream()`. `HttpClient` er trådsikker og kan deles:

```java
return soknader.parallelStream()
        .filter(s -> erGyldigFnr(client, mapper, baseUrl, s.fnr()))
        .toList();   // parallelStream beholder rekkefølgen ved toList()
```

**3. `erGyldigFnr`** gjør POST-kallet (fnr som JSON-streng) og leser
`status`:

```java
var req = HttpRequest.newBuilder(URI.create(baseUrl + "/api/fnr"))
        .header("Content-Type", "application/json")
        .POST(HttpRequest.BodyPublishers.ofString(mapper.writeValueAsString(fnr)))
        .build();
JsonNode svar = mapper.readTree(client.send(req, HttpResponse.BodyHandlers.ofString()).body());
return "valid".equals(svar.get("status").asText());
```

Stol på `status`-feltet — ingen Mod-11-beregning lokalt. (Pakk gjerne de
sjekkede unntakene fra `client.send` inn i en `try/catch` som returnerer
`false`.)
