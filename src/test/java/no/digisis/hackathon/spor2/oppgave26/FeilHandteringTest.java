package no.digisis.hackathon.spor2.oppgave26;

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
class FeilHandteringTest {

    @Autowired
    MockMvc mvc;

    @Test
    void testKjentSakGir200() throws Exception {
        mvc.perform(get("/saker/1"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id").value("1"));
    }

    @Test
    void testUkjentSakGir404MedFeil() throws Exception {
        mvc.perform(get("/saker/99"))
                .andExpect(status().isNotFound())
                .andExpect(jsonPath("$.feil").exists());
    }

    @Test
    void testFeilmeldingInneholderId() throws Exception {
        mvc.perform(get("/saker/77"))
                .andExpect(status().isNotFound())
                .andExpect(jsonPath("$.feil").value(org.hamcrest.Matchers.containsString("77")));
    }
}
