package no.digisis.hackathon.spor2.oppgave24;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.webmvc.test.autoconfigure.AutoConfigureMockMvc;
import org.springframework.http.MediaType;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
@DirtiesContext(classMode = DirtiesContext.ClassMode.AFTER_EACH_TEST_METHOD)
class SoknadOpprettControllerTest {

    @Autowired
    MockMvc mvc;

    @Test
    void testGyldigBodyGir201() throws Exception {
        String body = """
                {"fnr":"20058712345","fornavn":"Lara","etternavn":"Khan",
                 "alder":22,"postnummer":"9008","manedsinntekt":22000}
                """;
        mvc.perform(post("/soknader").contentType(MediaType.APPLICATION_JSON).content(body))
                .andExpect(status().isCreated());
    }

    @Test
    void testUgyldigFnrGir400() throws Exception {
        String body = """
                {"fnr":"abc","fornavn":"Lara","etternavn":"Khan",
                 "alder":22,"postnummer":"9008","manedsinntekt":22000}
                """;
        mvc.perform(post("/soknader").contentType(MediaType.APPLICATION_JSON).content(body))
                .andExpect(status().isBadRequest());
    }

    @Test
    void testBlankFornavnGir400() throws Exception {
        String body = """
                {"fnr":"20058712345","fornavn":"","etternavn":"Khan",
                 "alder":22,"postnummer":"9008","manedsinntekt":22000}
                """;
        mvc.perform(post("/soknader").contentType(MediaType.APPLICATION_JSON).content(body))
                .andExpect(status().isBadRequest());
    }

    @Test
    void testUgyldigPostnummerGir400() throws Exception {
        String body = """
                {"fnr":"20058712345","fornavn":"Lara","etternavn":"Khan",
                 "alder":22,"postnummer":"90","manedsinntekt":22000}
                """;
        mvc.perform(post("/soknader").contentType(MediaType.APPLICATION_JSON).content(body))
                .andExpect(status().isBadRequest());
    }
}
