package no.digisis.hackathon.spor2.oppgave06;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.io.TempDir;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class RobustCsvLeserTest {

    private static final String HEADER = "fnr,fornavn,etternavn,alder,postnummer,manedsinntekt";

    @TempDir
    Path tmp;

    private Path skriv(String... datalinjer) throws IOException {
        StringBuilder sb = new StringBuilder(HEADER).append('\n');
        for (String l : datalinjer) {
            sb.append(l).append('\n');
        }
        Path fil = tmp.resolve("soknader.csv");
        Files.writeString(fil, sb.toString(), StandardCharsets.UTF_8);
        return fil;
    }

    @Test
    void testAlleGyldigeGirIngenFeil() throws IOException {
        var resultat = RobustCsvLeser.les(skriv(
                "01059010006,Aisha,Hassan,34,0560,32000",
                "15079220008,Lin,Wang,32,0250,28500",
                "24038815071,Astrid,Berg,36,1389,72000"));
        assertEquals(3, resultat.gyldige().size());
        assertTrue(resultat.feil().isEmpty());
    }

    @Test
    void testToUgyldigeLinjerSamlesIFeil() throws IOException {
        var resultat = RobustCsvLeser.les(skriv(
                "01059010006,Aisha,Hassan,34,0560,32000",
                "15079220008,,Wang,32,0250,28500",          // blank fornavn
                "24038815071,Astrid,Berg,36,1389,72000",
                "01059010006,Negativ,Lonn,40,0560,-100"));   // negativ inntekt
        assertEquals(2, resultat.gyldige().size());
        assertEquals(2, resultat.feil().size());
    }

    @Test
    void testNegativInntektAvvises() throws IOException {
        var resultat = RobustCsvLeser.les(skriv(
                "01059010006,Aisha,Hassan,34,0560,-1"));
        assertEquals(0, resultat.gyldige().size());
        assertEquals(1, resultat.feil().size());
    }

    @Test
    void testBlankFornavnAvvises() throws IOException {
        var resultat = RobustCsvLeser.les(skriv(
                "01059010006,,Hassan,34,0560,32000"));
        assertEquals(0, resultat.gyldige().size());
        assertEquals(1, resultat.feil().size());
    }

    @Test
    void testUgyldigPostnummerAvvises() throws IOException {
        var resultat = RobustCsvLeser.les(skriv(
                "01059010006,Aisha,Hassan,34,56,32000"));
        assertEquals(0, resultat.gyldige().size());
        assertEquals(1, resultat.feil().size());
    }
}
