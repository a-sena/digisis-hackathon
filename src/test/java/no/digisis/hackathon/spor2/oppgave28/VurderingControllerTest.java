package no.digisis.hackathon.spor2.oppgave28;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.webmvc.test.autoconfigure.AutoConfigureMockMvc;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
class VurderingControllerTest {

    @Autowired
    MockMvc mvc;

    @Autowired
    VurderingService service;

    // DemoData: Aisha 32_000 (berettiget), Lin 28_500 (berettiget), Astrid 72_000 (ikke berettiget)

    @Test
    void testLavInntektGirBerettiget() throws Exception {
        mvc.perform(get("/vurdering/01059010006"))
                .andExpect(content().string("berettiget"));
    }

    @Test
    void testHoyInntektGirIkkeBerettiget() throws Exception {
        mvc.perform(get("/vurdering/24038815071"))
                .andExpect(content().string("ikke berettiget"));
    }

    @Test
    void testUkjentGirUkjent() throws Exception {
        mvc.perform(get("/vurdering/01010199934"))
                .andExpect(content().string("ukjent"));
    }

    @Test
    void testStatus200() throws Exception {
        mvc.perform(get("/vurdering/01059010006"))
                .andExpect(status().isOk());
    }

    @Test
    void testToNivaerWiringFungerer() {
        // Kontrolleren delegerer til tjenesten, som igjen bruker registeret:
        // den injiserte tjenesten svarer korrekt på samme data.
        org.junit.jupiter.api.Assertions.assertEquals("ikke berettiget", service.vurder("24038815071"));
    }
}
