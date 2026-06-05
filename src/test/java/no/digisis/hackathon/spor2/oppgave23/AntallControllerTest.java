package no.digisis.hackathon.spor2.oppgave23;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.webmvc.test.autoconfigure.AutoConfigureMockMvc;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.header;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
class AntallControllerTest {

    @Autowired
    MockMvc mvc;

    @Test
    void testGir200() throws Exception {
        mvc.perform(get("/antall-soknader"))
                .andExpect(status().isOk());
    }

    @Test
    void testHeaderXTotalCount() throws Exception {
        mvc.perform(get("/antall-soknader"))
                .andExpect(header().string("X-Total-Count", "3"));
    }

    @Test
    void testBodyAntall() throws Exception {
        mvc.perform(get("/antall-soknader"))
                .andExpect(jsonPath("$.antall").value(3));
    }

    @Test
    void testContentTypeJson() throws Exception {
        mvc.perform(get("/antall-soknader"))
                .andExpect(content().contentTypeCompatibleWith(MediaType.APPLICATION_JSON));
    }
}
