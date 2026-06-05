package no.digisis.hackathon.spor2.oppgave30;

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
class BeregningControllerTest {

    @Autowired
    MockMvc mvc;

    @Autowired
    BeregningService service;

    // andel = manedsinntekt × 12 × 100 / G, G = 118620.
    // Aisha 32_000 → 38_400_000 / 118620 = 323
    // Astrid 72_000 → 86_400_000 / 118620 = 728

    @Test
    void testKjentFnrGirBeregnetAndel() throws Exception {
        mvc.perform(get("/beregning/01059010006"))
                .andExpect(status().isOk())
                .andExpect(content().string("323"));
    }

    @Test
    void testAstridGir728() throws Exception {
        mvc.perform(get("/beregning/24038815071"))
                .andExpect(content().string("728"));
    }

    @Test
    void testUkjentFnrGirMinusEn() throws Exception {
        mvc.perform(get("/beregning/01010199934"))
                .andExpect(content().string("-1"));
    }

    @Test
    void testStatus200() throws Exception {
        mvc.perform(get("/beregning/01059010006"))
                .andExpect(status().isOk());
    }

    @Test
    void testKomponertWiringFungerer() {
        // BeregningService komponerer register + GrunnbelopKilde; den
        // injiserte tjenesten regner korrekt på samme data.
        org.junit.jupiter.api.Assertions.assertEquals(323, service.andelAvG("01059010006"));
    }
}
