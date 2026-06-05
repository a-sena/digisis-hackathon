package no.digisis.hackathon.spor2.oppgave29;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.webmvc.test.autoconfigure.AutoConfigureMockMvc;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
class KonfigDefaultTest {

    @Autowired
    MockMvc mvc;

    @Test
    void testDefaultVerdiGir200() throws Exception {
        mvc.perform(get("/konfig/grunnbelop"))
                .andExpect(status().isOk());
    }

    @Test
    void testDefaultVerdiReturneres() throws Exception {
        // Uten property-override skal defaulten (118620) brukes.
        mvc.perform(get("/konfig/grunnbelop"))
                .andExpect(content().string("118620"));
    }
}
