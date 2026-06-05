package no.digisis.hackathon.spor2.oppgave31;

import org.junit.jupiter.api.Test;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

/**
 * Frittstående MockMvc — interceptoren registreres bare her, ikke globalt,
 * så audit-loggen er fersk per test og påvirker ingen andre oppgaver.
 */
class AuditInterceptorTest {

    private MockMvc mvcMed(List<Auditpost> logg) {
        return MockMvcBuilders.standaloneSetup(new PingController())
                .addInterceptors(new AuditInterceptor(logg))
                .build();
    }

    @Test
    void testEnRequestGirEnAuditpost() throws Exception {
        List<Auditpost> logg = new ArrayList<>();
        mvcMed(logg).perform(get("/ping")).andExpect(status().isOk());
        assertEquals(1, logg.size());
    }

    @Test
    void testAuditpostHarMetodeStiOgStatus() throws Exception {
        List<Auditpost> logg = new ArrayList<>();
        mvcMed(logg).perform(get("/ping")).andExpect(status().isOk());
        Auditpost post = logg.get(0);
        assertEquals("GET", post.metode());
        assertEquals("/ping", post.sti());
        assertEquals(200, post.status());
    }

    @Test
    void testToRequesterGirToPoster() throws Exception {
        List<Auditpost> logg = new ArrayList<>();
        var mvc = mvcMed(logg);
        mvc.perform(get("/ping"));
        mvc.perform(get("/ping"));
        assertEquals(2, logg.size());
    }
}
