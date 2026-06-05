package no.digisis.hackathon.spor2.oppgave31;

/** Én linje i revisjonssporet: hvilken request traff oss, og med hvilket svar. */
public record Auditpost(String metode, String sti, int status) {}
