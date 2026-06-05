# Hjelp — Oppgave 25: Egendefinert validator

Bean Validation lar deg lage dine egne constraints. Her er rammeverket
allerede satt opp for deg:

- `@GyldigDekningsgrad` er annotasjonen (peker på validatoren via
  `@Constraint(validatedBy = ...)`).
- `VurderRequest` bruker den på `dekningsgrad`-feltet.
- `VurderSoknadController` kjører `@Valid` og svarer 200 når alt er gyldig.

Du skal kun fylle inn `isValid(...)` i `DekningsgradValidator`:

- returner `true` kun når verdien er `80` eller `100`,
- returner `false` ellers (husk `null`-tilfellet).

Når `isValid` gir `false`, avviser `@Valid` requesten med 400 helt
automatisk — du trenger ikke røre kontrolleren.
