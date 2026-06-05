# Hjelp — Oppgave 40: Utbetalingsplan

- `int dagsats = grunnlag / 260;` (heltallsdivisjon gir gulvet),
  `int ukesats = dagsats * 5;`.
- Bygg én `Utbetalingslinje` per uke i en løkke fra `1` til `antallUker`.
- `java.time.LocalDate` gjør datoregningen triviell:

```java
LocalDate fra = startDato.plusWeeks(i - 1);   // eller .plusDays((i-1)*7)
LocalDate til = fra.plusDays(6);
```

Returner en `List` — `antallUker = 0` gir en tom liste (`List.of()`).
Merk at heltallsdivisjonen kapper desimaler bort: `100000 / 260 = 384`,
ikke 384,6.
