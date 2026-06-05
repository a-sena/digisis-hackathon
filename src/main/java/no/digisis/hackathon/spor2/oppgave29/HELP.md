# Hjelp — Oppgave 29: Konfigurasjon og properties

Grunnbeløpet (G) endres hvert år, så det bør være konfigurerbart i stedet
for hardkodet. `@Value` leser en property med en default-verdi:

    @Value("${dds.grunnbelop:118620}")
    int grunnbelop;

Syntaksen `${navn:default}` betyr "bruk `dds.grunnbelop` hvis satt, ellers
118620". Feltet er allerede satt opp for deg.

Du skal bare returnere den injiserte verdien fra `grunnbelop()`.

Testene viser to scenarier:
- `@SpringBootTest(properties = "dds.grunnbelop=124028")` overstyrer
  verdien → endepunktet skal returnere 124028.
- uten override → defaulten 118620.
