package no.digisis.hackathon.spor2.oppgave43;

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
class NotatSideControllerTest {

    @Autowired
    MockMvc mvc;

    @Test
    void testForsteSideGirToNotater() throws Exception {
        mvc.perform(get("/notater?side=0&storrelse=2"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.innhold.length()").value(2))
                .andExpect(jsonPath("$.totalt").value(3))
                .andExpect(jsonPath("$.innhold[0].fnr").value("1"));
    }

    @Test
    void testAndreSideGirResten() throws Exception {
        mvc.perform(get("/notater?side=1&storrelse=2"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.innhold.length()").value(1))
                .andExpect(jsonPath("$.innhold[0].fnr").value("3"));
    }

    @Test
    void testDefaultGirAlle() throws Exception {
        mvc.perform(get("/notater"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.innhold.length()").value(3));
    }

    @Test
    void testTotaltErAlltid3() throws Exception {
        mvc.perform(get("/notater?side=1&storrelse=2"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.totalt").value(3));
    }

    @Test
    void testInnholdErSortert() throws Exception {
        mvc.perform(get("/notater?side=0&storrelse=3"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.innhold[0].fnr").value("1"))
                .andExpect(jsonPath("$.innhold[1].fnr").value("2"))
                .andExpect(jsonPath("$.innhold[2].fnr").value("3"));
    }
}
