package no.digisis.hackathon.spor2.oppgave25;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.webmvc.test.autoconfigure.AutoConfigureMockMvc;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
class DekningsgradValidatorTest {

    @Autowired
    MockMvc mvc;

    @Test
    void testDekning100Gir200() throws Exception {
        String body = """
                {"fnr":"01059010006","dekningsgrad":100}
                """;
        mvc.perform(post("/vurder-soknad").contentType(MediaType.APPLICATION_JSON).content(body))
                .andExpect(status().isOk());
    }

    @Test
    void testDekning80Gir200() throws Exception {
        String body = """
                {"fnr":"01059010006","dekningsgrad":80}
                """;
        mvc.perform(post("/vurder-soknad").contentType(MediaType.APPLICATION_JSON).content(body))
                .andExpect(status().isOk());
    }

    @Test
    void testDekning90Gir400() throws Exception {
        String body = """
                {"fnr":"01059010006","dekningsgrad":90}
                """;
        mvc.perform(post("/vurder-soknad").contentType(MediaType.APPLICATION_JSON).content(body))
                .andExpect(status().isBadRequest());
    }

    @Test
    void testUgyldigFnrGir400() throws Exception {
        String body = """
                {"fnr":"abc","dekningsgrad":100}
                """;
        mvc.perform(post("/vurder-soknad").contentType(MediaType.APPLICATION_JSON).content(body))
                .andExpect(status().isBadRequest());
    }
}
