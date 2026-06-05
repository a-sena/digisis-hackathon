package no.digisis.hackathon.spor2.oppgave43;

import java.util.List;

/** Sidesvar for paginering. Serialiseres til JSON av Spring. */
public record Side(int side, int storrelse, int totalt, List<Saksnotat> innhold) {}
