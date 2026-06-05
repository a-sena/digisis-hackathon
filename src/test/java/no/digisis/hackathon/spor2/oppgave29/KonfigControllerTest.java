package no.digisis.hackathon.spor2.oppgave29;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.webmvc.test.autoconfigure.AutoConfigureMockMvc;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest(properties = "dds.grunnbelop=124028")
@AutoConfigureMockMvc
class KonfigControllerTest {

    @Autowired
    MockMvc mvc;

    @Test
    void testOverstyrtVerdiGir200() throws Exception {
        mvc.perform(get("/konfig/grunnbelop"))
                .andExpect(status().isOk());
    }

    @Test
    void testOverstyrtVerdiReturneres() throws Exception {
        mvc.perform(get("/konfig/grunnbelop"))
                .andExpect(content().string("124028"));
    }
}
