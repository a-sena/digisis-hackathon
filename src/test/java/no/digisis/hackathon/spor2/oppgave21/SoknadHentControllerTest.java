package no.digisis.hackathon.spor2.oppgave21;

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
class SoknadHentControllerTest {

    @Autowired
    MockMvc mvc;

    @Test
    void testKjentFnrGir200() throws Exception {
        mvc.perform(get("/soknader/01059010006"))
                .andExpect(status().isOk());
    }

    @Test
    void testUkjentFnrGir404() throws Exception {
        mvc.perform(get("/soknader/01010199934"))
                .andExpect(status().isNotFound());
    }

    @Test
    void testBodyInneholderFnr() throws Exception {
        mvc.perform(get("/soknader/01059010006"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.fnr.verdi").value("01059010006"));
    }
}
