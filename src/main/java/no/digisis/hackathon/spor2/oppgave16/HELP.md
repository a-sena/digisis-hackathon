# Hjelp — Oppgave 16: Serialiser Sak til JSON

Jackson er allerede med i Spring Boot — slå opp hvordan du
serialiserer et vilkårlig objekt til JSON.

Du trenger ingen annotations. Jackson reflekterer over `record`-typer
sine accessor-metoder rett ut av boksen.

Spring Boot bruker det samme biblioteket internt. Når du i web-oppgavene
ser JSON-respons fra `curl`, vet du nå hvordan den blir til.
