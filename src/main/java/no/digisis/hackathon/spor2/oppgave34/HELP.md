# Hjelp — Oppgave 34: Retry med backoff

En generisk retry-løkke. `Supplier<T>` er et kall som gir en `T` (eller
kaster). Du skal kjøre det, og prøve på nytt hvis det kaster.

```java
public static <T> T medRetry(Supplier<T> kall, int forsok) {
    RuntimeException siste = null;
    for (int i = 0; i < forsok; i++) {
        try {
            return kall.get();          // første suksess returneres med en gang
        } catch (RuntimeException e) {
            siste = e;
            // backoff: her ville du ventet litt før neste forsøk
        }
    }
    throw siste;                        // alle forsøk feilet → kast det siste videre
}
```

Merk:
- `forsok` er TOTALT antall forsøk (ikke antall *ekstra* forsøk).
- Lykkes det første gang, skal `kall` bare ha blitt kjørt én gang.
- Vi hopper over ekte `Thread.sleep` her for å holde testene raske og
  deterministiske — en kommentar der pausen ville vært, holder.
