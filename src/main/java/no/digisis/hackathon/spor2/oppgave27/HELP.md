# Hjelp — Oppgave 27: ProblemDetail (RFC 7807)

`ProblemDetail` er Spring sin innebygde modell for standardiserte
feilsvar (RFC 7807). I stedet for en egen `Map` kan du returnere en
`ProblemDetail` direkte fra en `@ExceptionHandler`, og Spring setter
status og `Content-Type: application/problem+json` for deg.

Du skal legge til én handler i `ProblemDetaljHandtering`:

1. `@ExceptionHandler(VedtakIkkeFunnet.class)`.
2. Bygg en `ProblemDetail`:

       ProblemDetail pd = ProblemDetail.forStatusAndDetail(HttpStatus.NOT_FOUND, e.getMessage());
       pd.setTitle("Vedtak ikke funnet");
       return pd;

`VedtakController` er ferdig — den kaster `VedtakIkkeFunnet` for ukjente
id-er. Håndter KUN denne exceptionen, ikke en bred `Exception`.
