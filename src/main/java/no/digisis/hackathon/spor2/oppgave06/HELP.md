# Hjelp — Oppgave 6: Robust parsing med feilsamling

Samme CSV-format som oppgave 5, men med to forskjeller:

1. Du validerer IKKE fnr mot API-et — dette er ren parsing.
2. En enkelt feil-linje skal ikke stoppe innlesningen. Den noteres og
   du går videre.

Bygg opp to lister mens du leser:

- `gyldige` — alle `ForeldrepengerSoknad` som lot seg bygge.
- `feil` — én streng per linje som feilet, på formen `"linje N: <melding>"`.

Linjenummeret `N` er linjas plass i fila. Header er linje 1, så første
data-linje er linje 2. Tell opp en linjeteller mens du itererer.

Mønster:

```java
for (hver datalinje, med linjenummer n) {
    try {
        // split på komma, parse felt, bygg ForeldrepengerSoknad
        gyldige.add(soknad);
    } catch (Exception e) {
        feil.add("linje " + n + ": " + e.getMessage());
    }
}
```

Det som kan kaste:
- `Integer.parseInt(...)` på ikke-numerisk alder/inntekt
  (`NumberFormatException`).
- `ForeldrepengerSoknad`-konstruktøren på blankt navn, negativ inntekt
  eller ugyldig postnummer (`IllegalArgumentException`).

Begge er underklasser av `Exception`, så ett `catch (Exception e)` fanger
alt. Returnér til slutt `new Resultat(gyldige, feil)`.
