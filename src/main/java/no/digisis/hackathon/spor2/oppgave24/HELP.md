# Hjelp — Oppgave 24: POST /soknader med Bean Validation

**Bean Validation** sjekker felter i input-DTO-en før metoden i det
hele tatt kalles: blanke felt og feil format (fnr som ikke er 11 sifre,
postnummer som ikke er 4 sifre, negativ alder/inntekt) gir 400 helt
automatisk via `@Valid`. Du trenger altså ikke validere manuelt — bare
sørg for at `@Valid` står på parameteret (det gjør det allerede).

Det er ingen lokal Mod-11-sjekk i dette prosjektet — ekte
fnr-validering gjøres mot `api.digisis.org/api/fnr`.

Når input er gyldig:

1. Bygg en `ForeldrepengerSoknad` fra feltene i requesten
   (`Fodselsnummer.av(request.fnr())`).
2. Legg den i registeret.
3. Returner 201 Created med en Location-header. Slå opp
   `ResponseEntity.created(uri)` — URI-en kan peke på `/soknader/{fnr}`.
