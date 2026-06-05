package no.digisis.hackathon.spor2.oppgave27;

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
class ProblemDetaljHandteringTest {

    @Autowired
    MockMvc mvc;

    @Test
    void testKjentVedtakGir200() throws Exception {
        mvc.perform(get("/vedtak/1"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.utfall").value("Innvilget"));
    }

    @Test
    void testUkjentVedtakGir404() throws Exception {
        mvc.perform(get("/vedtak/99"))
                .andExpect(status().isNotFound());
    }

    @Test
    void testProblemDetailHarTitle() throws Exception {
        mvc.perform(get("/vedtak/99"))
                .andExpect(jsonPath("$.title").value("Vedtak ikke funnet"));
    }

    @Test
    void testProblemDetailHarStatus404() throws Exception {
        mvc.perform(get("/vedtak/99"))
                .andExpect(jsonPath("$.status").value(404));
    }
}
