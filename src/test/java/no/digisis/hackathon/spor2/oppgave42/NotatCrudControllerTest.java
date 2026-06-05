package no.digisis.hackathon.spor2.oppgave42;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.webmvc.test.autoconfigure.AutoConfigureMockMvc;
import org.springframework.http.MediaType;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
@DirtiesContext(classMode = DirtiesContext.ClassMode.AFTER_EACH_TEST_METHOD)
class NotatCrudControllerTest {

    @Autowired
    MockMvc mvc;

    @Test
    void testPutEksisterendeGir200() throws Exception {
        mvc.perform(put("/notater/1").contentType(MediaType.APPLICATION_JSON)
                        .content("{\"fnr\":\"1\",\"tekst\":\"oppdatert\"}"))
                .andExpect(status().isOk());
    }

    @Test
    void testPutUkjentGir404MedFeil() throws Exception {
        mvc.perform(put("/notater/99").contentType(MediaType.APPLICATION_JSON)
                        .content("{\"fnr\":\"99\",\"tekst\":\"x\"}"))
                .andExpect(status().isNotFound())
                .andExpect(jsonPath("$.feil").exists());
    }

    @Test
    void testDeleteEksisterendeGir204() throws Exception {
        mvc.perform(delete("/notater/2"))
                .andExpect(status().isNoContent());
    }

    @Test
    void testDeleteUkjentGir404MedFeil() throws Exception {
        mvc.perform(delete("/notater/99"))
                .andExpect(status().isNotFound())
                .andExpect(jsonPath("$.feil").exists());
    }

    @Test
    void testPutOppdatererTekst() throws Exception {
        mvc.perform(put("/notater/1").contentType(MediaType.APPLICATION_JSON)
                        .content("{\"fnr\":\"1\",\"tekst\":\"ny tekst\"}"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.tekst").value("ny tekst"));
    }
}
