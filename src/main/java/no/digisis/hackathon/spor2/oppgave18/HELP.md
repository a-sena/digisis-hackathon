# Hjelp — Oppgave 18: DTO ↔ domene-mapping

En DTO (Data Transfer Object) er en egen type for det som faktisk
sendes ut av tjenesten. Den lar deg skille intern modell fra ekstern
kontrakt — og skjule sensitive felter, som fødselsnummer.

`SoknadDto` er ferdig definert. Du skal fylle den i `tilDto`.

**Navn:** `fornavn + " " + etternavn`.

**Maskering:** behold de 4 siste sifrene, bytt resten med `*`. Et
11-sifret fnr blir `*******1234` (7 stjerner). Hint:

```java
String fnr = soknad.fnr().verdi();
String maskert = "*".repeat(fnr.length() - 4) + fnr.substring(fnr.length() - 4);
```

`postnummer` og `manedsinntekt` kopieres rett over. Det rå fnr-et skal
aldri lagres i DTO-en.
