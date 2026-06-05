# Hjelp — Oppgave 19: Custom feltnavn & format

Her bestemmer du selv JSON-nøklene. To vanlige måter med Jackson:

**1. Egen DTO med `@JsonProperty`.** `EksternSoknad` er allerede annotert
med de eksterne nøklene. Bygg den og serialiser:

```java
EksternSoknad ekstern = new EksternSoknad(maskertFnr, navn, postnr, inntekt);
return new ObjectMapper().writeValueAsString(ekstern);
```

**2. Bygg en `ObjectNode` / `Map` manuelt** og serialiser den — også greit
hvis du heller vil styre nøklene direkte.

Gjenbruk maskeringen fra oppgave 18 (`*******1234`) og slå sammen navnet
(`fornavn + " " + etternavn`). Pass på at domenefeltnavnene (`fornavn`,
`etternavn`, `fnr`) IKKE havner i utdataene — bare de fire eksterne
nøklene.
