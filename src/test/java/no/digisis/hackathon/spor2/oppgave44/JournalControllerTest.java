package no.digisis.hackathon.spor2.oppgave44;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.webmvc.test.autoconfigure.AutoConfigureMockMvc;
import org.springframework.http.MediaType;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.header;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
@DirtiesContext(classMode = DirtiesContext.ClassMode.AFTER_EACH_TEST_METHOD)
class JournalControllerTest {

    @Autowired
    MockMvc mvc;

    @Test
    void testForsteSkrivingGir200OgTeller1() throws Exception {
        mvc.perform(put("/journal/a").contentType(MediaType.APPLICATION_JSON)
                        .content("{\"id\":\"a\",\"tekst\":\"hei\"}"))
                .andExpect(status().isOk())
                .andExpect(header().string("X-Skrivinger", "1"));
    }

    @Test
    void testSammeBodyToGangerErIdempotent() throws Exception {
        mvc.perform(put("/journal/a").contentType(MediaType.APPLICATION_JSON)
                        .content("{\"id\":\"a\",\"tekst\":\"hei\"}"))
                .andExpect(status().isOk())
                .andExpect(header().string("X-Skrivinger", "1"));
        mvc.perform(put("/journal/a").contentType(MediaType.APPLICATION_JSON)
                        .content("{\"id\":\"a\",\"tekst\":\"hei\"}"))
                .andExpect(status().isOk())
                .andExpect(header().string("X-Skrivinger", "2"))
                .andExpect(jsonPath("$.tekst").value("hei"));
    }

    @Test
    void testForskjelligTekstOppdatererBody() throws Exception {
        mvc.perform(put("/journal/a").contentType(MediaType.APPLICATION_JSON)
                        .content("{\"id\":\"a\",\"tekst\":\"hei\"}"))
                .andExpect(status().isOk());
        mvc.perform(put("/journal/a").contentType(MediaType.APPLICATION_JSON)
                        .content("{\"id\":\"a\",\"tekst\":\"oppdatert\"}"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.tekst").value("oppdatert"));
    }

    @Test
    void testBodyRundtur() throws Exception {
        mvc.perform(put("/journal/b").contentType(MediaType.APPLICATION_JSON)
                        .content("{\"id\":\"b\",\"tekst\":\"notat\"}"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id").value("b"))
                .andExpect(jsonPath("$.tekst").value("notat"));
    }
}
