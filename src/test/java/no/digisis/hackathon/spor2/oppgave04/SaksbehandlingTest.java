package no.digisis.hackathon.spor2.oppgave04;

import no.digisis.hackathon.spor2.oppgave04.Hendelse.Avvis;
import no.digisis.hackathon.spor2.oppgave04.Hendelse.FattVedtak;
import no.digisis.hackathon.spor2.oppgave04.Hendelse.StartBehandling;
import no.digisis.hackathon.spor2.oppgave04.Saksstatus.Avvist;
import no.digisis.hackathon.spor2.oppgave04.Saksstatus.Mottatt;
import no.digisis.hackathon.spor2.oppgave04.Saksstatus.UnderBehandling;
import no.digisis.hackathon.spor2.oppgave04.Saksstatus.Vedtak;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class SaksbehandlingTest {

    @Test
    void testMottattStartBehandlingGirUnderBehandling() {
        var neste = Saksbehandling.neste(new Mottatt(), new StartBehandling("Aisha"));
        assertEquals(new UnderBehandling("Aisha"), neste);
    }

    @Test
    void testUnderBehandlingFattVedtakGirVedtak() {
        var neste = Saksbehandling.neste(new UnderBehandling("Aisha"), new FattVedtak("innvilget"));
        assertEquals(new Vedtak("innvilget"), neste);
    }

    @Test
    void testUnderBehandlingAvvisGirAvvist() {
        var neste = Saksbehandling.neste(new UnderBehandling("Aisha"), new Avvis("mangler dokumentasjon"));
        assertEquals(new Avvist("mangler dokumentasjon"), neste);
    }

    @Test
    void testMottattFattVedtakKaster() {
        assertThrows(IllegalStateException.class,
                () -> Saksbehandling.neste(new Mottatt(), new FattVedtak("innvilget")));
    }

    @Test
    void testVedtakStartBehandlingKaster() {
        assertThrows(IllegalStateException.class,
                () -> Saksbehandling.neste(new Vedtak("innvilget"), new StartBehandling("Aisha")));
    }

    @Test
    void testAvvistStartBehandlingKaster() {
        assertThrows(IllegalStateException.class,
                () -> Saksbehandling.neste(new Avvist("mangler dokumentasjon"), new StartBehandling("Aisha")));
    }

    @Test
    void testUnderBehandlingStartBehandlingKaster() {
        assertThrows(IllegalStateException.class,
                () -> Saksbehandling.neste(new UnderBehandling("Aisha"), new StartBehandling("Lin")));
    }
}
