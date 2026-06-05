# Hjelp — Oppgave 31: Middleware / interceptor (revisjonsspor)

En `HandlerInterceptor` kjører rundt hver request — som Hono sin
`app.use(...)`. Du skal føre et revisjonsspor: én `Auditpost` per
ferdigbehandlet request.

- Implementer `afterCompletion(...)`. Den kjøres etter at svaret er
  klart, så du kan lese statuskoden.
- Legg til `new Auditpost(request.getMethod(), request.getRequestURI(),
  response.getStatus())` i `logg`.
- Testen registrerer interceptoren på en frittstående `MockMvc` og
  sjekker at loggen får én post per request — så her trenger du ikke
  tenke på global oppsett.

Poenget er tverrgående logikk ett sted, i stedet for i hver kontroller.
