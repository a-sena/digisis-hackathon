package no.digisis.hackathon.spor2.oppgave22;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.webmvc.test.autoconfigure.AutoConfigureMockMvc;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
class SoknadFilterControllerTest {

    @Autowired
    MockMvc mvc;

    // DemoData: Aisha (alder 34, 32_000), Lin (alder 32, 28_500), Astrid (alder 36, 72_000)

    @Test
    void testUtenParamReturnererAlle() throws Exception {
        mvc.perform(get("/soknader/filter"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.length()").value(3));
    }

    @Test
    void testMinInntektFiltrerer() throws Exception {
        // inntekt ≥ 30_000 → Aisha (32_000) og Astrid (72_000)
        mvc.perform(get("/soknader/filter?minInntekt=30000"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.length()").value(2));
    }

    @Test
    void testMaxAlderFiltrerer() throws Exception {
        // alder ≤ 34 → Aisha (34) og Lin (32)
        mvc.perform(get("/soknader/filter?maxAlder=34"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.length()").value(2));
    }

    @Test
    void testBeggeKombinert() throws Exception {
        // inntekt ≥ 30_000 OG alder ≤ 34 → kun Aisha (34, 32_000)
        mvc.perform(get("/soknader/filter?minInntekt=30000&maxAlder=34"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.length()").value(1));
    }
}
