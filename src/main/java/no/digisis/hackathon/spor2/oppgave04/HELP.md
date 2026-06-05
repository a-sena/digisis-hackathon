# Hjelp — Oppgave 4: Saksstatus-tilstandsmaskin

`Saksstatus` og `Hendelse` er ferdige sum-typer (`sealed interface` med
`record`-varianter). Du skal skrive `Saksbehandling.neste(status, hendelse)`.

Bare tre overganger er lovlige:

| Fra              | Hendelse            | Til                    |
|------------------|---------------------|------------------------|
| `Mottatt`        | `StartBehandling`   | `UnderBehandling(sb)`  |
| `UnderBehandling`| `FattVedtak`        | `Vedtak(utfall)`       |
| `UnderBehandling`| `Avvis`             | `Avvist(grunn)`        |

Alt annet → `throw new IllegalStateException(...)`.

Bruk et `switch` med pattern-matching over *paret* `(status, hendelse)`.
En ryddig variant er å matche på `status` ytterst, og på `hendelse`
innerst:

```java
return switch (status) {
    case Saksstatus.Mottatt m -> switch (hendelse) {
        case Hendelse.StartBehandling sb -> new Saksstatus.UnderBehandling(sb.saksbehandler());
        default -> throw new IllegalStateException(...);
    };
    case Saksstatus.UnderBehandling u -> switch (hendelse) {
        case Hendelse.FattVedtak fv -> new Saksstatus.Vedtak(fv.utfall());
        case Hendelse.Avvis a       -> new Saksstatus.Avvist(a.grunn());
        default -> throw new IllegalStateException(...);
    };
    default -> throw new IllegalStateException(...);
};
```

Fordi typene er `sealed` slipper du å bekymre deg for «glemte» varianter
— kompilatoren krever at switchen er uttømmende.
