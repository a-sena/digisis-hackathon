# Hjelp — Oppgave 17: Deserialiser JSON → domene

Du skal gå motsatt vei av oppgave 16: fra `String` til `Soknad`.

```java
ObjectMapper mapper = new ObjectMapper();
Soknad soknad = mapper.readValue(json, Soknad.class);
```

Jackson fyller `record`-feltene fra JSON-nøklene med samme navn, og
parser den nøstede `inntektshistorikk`-lista automatisk (den kjenner
elementtypen `Inntektsregistrering` fra deklarasjonen).

**Ukjente felter.** Et ekte API legger ofte til nye felter over tid.
Standard-mapperen kaster da `UnrecognizedPropertyException`. Skru det
av så koden tåler at API-et vokser:

```java
mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
```

Felter som mangler i JSON-en blir satt til Java-default (`null` for
objekter/`String`, `0` for `int`) — det er greit her.
