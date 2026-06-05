# Hjelp — Oppgave 39: Stønadsperiode-oppslag

Et oppslag. Finn grunnperioden ut fra rettsforhold + dekningsgrad, og
legg til flerbarns-tillegget ut fra antall barn + dekningsgrad:

```java
int grunn = rettsforhold.equals("begge")
        ? (dekningsgrad == 100 ? 49 : 61)
        : (dekningsgrad == 100 ? 40 : 52);
int tillegg = antallBarn <= 1 ? 0
        : antallBarn == 2 ? (dekningsgrad == 100 ? 17 : 21)
        :                   (dekningsgrad == 100 ? 46 : 57);
return grunn + tillegg;
```

`"kun-mor"` og `"kun-far"` deler samme grunnperiode (40 / 52).
Flerbarns-tillegget er det samme uansett rettsforhold. Totalt =
grunnperiode + tillegg.
