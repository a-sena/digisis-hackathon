package no.digisis.hackathon.spor2.oppgave18;

import no.digisis.hackathon.spor2.domain.Fodselsnummer;
import no.digisis.hackathon.spor2.domain.ForeldrepengerSoknad;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;

class SoknadMapperTest {

    private static ForeldrepengerSoknad aisha() {
        return new ForeldrepengerSoknad(
                Fodselsnummer.av("01059011234"), "Aisha", "Hassan", 34, "0560", 32_000);
    }

    @Test
    void testNavnSlasSammen() {
        assertEquals("Aisha Hassan", SoknadMapper.tilDto(aisha()).navn());
    }

    @Test
    void testMaskertFnr() {
        // 11 sifre: 7 stjerner + de 4 siste.
        assertEquals("*******1234", SoknadMapper.tilDto(aisha()).maskertFnr());
    }

    @Test
    void testPostnummerOgInntektKopieres() {
        SoknadDto dto = SoknadMapper.tilDto(aisha());
        assertEquals("0560", dto.postnummer());
        assertEquals(32_000, dto.manedsinntekt());
    }

    @Test
    void testAnnenSoker() {
        ForeldrepengerSoknad lin = new ForeldrepengerSoknad(
                Fodselsnummer.av("15079225678"), "Lin", "Wang", 32, "0250", 28_500);
        SoknadDto dto = SoknadMapper.tilDto(lin);
        assertEquals("Lin Wang", dto.navn());
        assertEquals("*******5678", dto.maskertFnr());
        assertEquals("0250", dto.postnummer());
        assertEquals(28_500, dto.manedsinntekt());
    }

    @Test
    void testRaaFnrAldriEksponert() {
        SoknadDto dto = SoknadMapper.tilDto(aisha());
        assertFalse(dto.maskertFnr().contains("0105901"),
                "maskertFnr skal ikke inneholde de skjulte sifrene");
        assertEquals(7, dto.maskertFnr().chars().filter(c -> c == '*').count());
    }
}
