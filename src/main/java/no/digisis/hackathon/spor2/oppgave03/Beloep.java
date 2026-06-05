package no.digisis.hackathon.spor2.oppgave03;

/**
 * Oppgave 3 — Pengebeløp som verdiobjekt (15 poeng)
 *
 * <p>Et beløp i hele kroner, modellert som et lite verdiobjekt. Poenget
 * er å samle reglene for penger ett sted, slik at resten av systemet
 * slipper å gjenta dem:
 *
 * <ul>
 *   <li>{@link #av(int)} — fabrikkmetode som avviser negative beløp
 *       ({@link IllegalArgumentException}).</li>
 *   <li>{@link #pluss(Beloep)} — legg sammen to beløp.</li>
 *   <li>{@link #prosentAv(int)} — {@code kroner * prosent / 100} (heltall).</li>
 *   <li>{@link #kapp(Beloep)} — kapp ved et tak (returner det minste).</li>
 * </ul>
 *
 * <p>Et {@code record} er uforanderlig: hver operasjon returnerer et
 * <em>nytt</em> {@link Beloep}, den opprinnelige endres aldri.
 */
public record Beloep(int kroner) {

    public static Beloep av(int kroner) {
        // TODO
        if (kroner < 0) {
            throw new IllegalArgumentException("Beløp kan ikke være negativt: " + kroner);
        }
        return new Beloep(kroner);
    }

    public Beloep pluss(Beloep annet) {
        // TODO
        if (annet == null) {
            return this;
        }
        return new Beloep(this.kroner + annet.kroner());
    }

    public Beloep prosentAv(int prosent) {
        // TODO
        int regnetBeloep = (this.kroner * prosent) / 100;
        return Beloep.av(regnetBeloep);
    }

    public Beloep kapp(Beloep tak) {
        // TODO
        if (tak == null) {
            return this;
        }
        int minsteKroner = Math.min(this.kroner, tak.kroner());
        return new Beloep(minsteKroner);
    }
    }