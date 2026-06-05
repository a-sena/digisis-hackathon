# Hjelp — Oppgave 11: Flat-map & aggregering

To-trinns problem på nøstede data:

1. **Flat ut.** Hver soknad har en liste med inntektsregistreringer. Du
   vil behandle alle registreringene som én lang strøm — uavhengig av
   hvilken soknad de kom fra. Det er nettopp det `flatMap` gjør:
   `soknader.stream().flatMap(s -> s.inntektshistorikk().stream())`.
2. **Grupper og summer.** Grupper strømmen på `type`, og summer `belop`
   i hver gruppe med `Collectors.groupingBy(..., Collectors.summingLong(...))`.

Merk at `summingLong` gir `Long`-verdier — resultatet er
`Map<Inntektstype, Long>`. En type som aldri forekommer skal ikke ha en
nøkkel i mappet (du legger ikke inn nuller selv). Tom inputliste → tomt
map.
