package no.digisis.hackathon.spor2.oppgave35;

import no.digisis.hackathon.spor2.domain.Soknad;

/**
 * Oppgave 35 — Vedtaksmotor (30 poeng)
 *
 * <p>Bygg en regelmotor som tar én {@link Soknad} og fatter et
 * {@link Vedtak}. Reglene er en forenklet versjon av NAV sine
 * foreldrepenger-regler, og skal anvendes <b>i rekkefølge</b> — hvert
 * steg avgjør vedtaket (terminal) eller slipper søknaden videre.
 *
 * <p><b>Steg 1 — Opptjening.</b> Alle tre må holde:
 * <ol>
 *   <li>{@code erNorskBorger == true}</li>
 *   <li>godkjent inntekt i <b>minst 6</b> av månedene i
 *       {@code inntektshistorikk} (godkjent = alle inntektstyper UNNTATT
 *       {@code STIPEND_LANEKASSEN})</li>
 *   <li>annualisert godkjent inntekt ≥ ½G:
 *       {@code sum(godkjent belop) * 12 / 10 >= HALV_G}</li>
 * </ol>
 * Holder alt → gå til steg 2.
 *
 * <p><b>Steg 1b — Fallback</b> når opptjening ikke holder:
 * {@code erNorskBorger} → {@link Vedtak.Engangsstonad}, ellers
 * {@link Vedtak.Avslag}.
 *
 * <p><b>Steg 2 — Beregningsgrunnlag</b> (kun når opptjening holdt):
 * <ul>
 *   <li>årssats = snitt av de <b>3 siste</b> månedene × 12.</li>
 *   <li>Avvik: hvis {@code oppgittArsinntekt > 0} og
 *       {@code |årssats - oppgittArsinntekt| / oppgittArsinntekt > 0.25}
 *       → {@link Vedtak.ManuellVurdering}. (Hopp over når oppgitt = 0.)</li>
 *   <li>Kapp ved 6G: {@code grunnlag = min(årssats, SEKS_G)} →
 *       {@link Vedtak.Innvilget}.</li>
 * </ul>
 */
public final class Vedtaksmotor {

    /** ½G i kroner (2025-tall). */
    public static final int HALV_G = 65_080;
    /** 6G i kroner (2025-tall). */
    public static final int SEKS_G = 780_960;

    private Vedtaksmotor() {}

    public static Vedtak vurder(Soknad soknad) {
        // TODO
        throw new UnsupportedOperationException("Oppgave 35 — ikke implementert ennå");
    }
}
