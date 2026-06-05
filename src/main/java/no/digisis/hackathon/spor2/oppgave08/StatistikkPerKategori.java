package no.digisis.hackathon.spor2.oppgave08;

import no.digisis.hackathon.spor2.domain.ForeldrepengerSoknad;
import no.digisis.hackathon.spor2.domain.Inntektskategori;

import java.util.List;
import java.util.Map;

/**
 * Oppgave 8 — Statistikk per inntektskategori (15 poeng)
 *
 * Lag en oversikt for lederen: hvor mange soknader har vi i hver kategori,
 * og hva er gjennomsnittsinntekten innenfor kategorien?
 *
 * Bruk {@link Inntektskategori#av(int)} til å plassere hver soknad i
 * riktig kategori, og {@link java.util.stream.Collectors} for
 * oppsummeringen.
 */
public final class StatistikkPerKategori {

    public record Statistikk(long antall, double snittInntekt) {}

    private StatistikkPerKategori() {}

    public static Map<Inntektskategori, Statistikk> beregn(List<ForeldrepengerSoknad> soknader) {
        // TODO: grupper på Inntektskategori.av(s.manedsinntekt()),
        //       og for hver gruppe regn ut (antall, snitt månedsinntekt).
        throw new UnsupportedOperationException("Oppgave 8 — ikke implementert ennå");
    }
}
