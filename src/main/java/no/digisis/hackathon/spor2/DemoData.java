package no.digisis.hackathon.spor2;

import no.digisis.hackathon.spor2.domain.Fodselsnummer;
import no.digisis.hackathon.spor2.domain.ForeldrepengerSoknad;
import no.digisis.hackathon.spor2.oppgave12.SoknadsRegister;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
class DemoData {

    @Bean
    SoknadsRegister soknadsRegister() {
        var register = new SoknadsRegister();
        register.leggTil(new ForeldrepengerSoknad(Fodselsnummer.av("01059010006"), "Aisha", "Hassan", 34, "0560", 32_000));
        register.leggTil(new ForeldrepengerSoknad(Fodselsnummer.av("15079220008"), "Lin", "Wang", 32, "0250", 28_500));
        register.leggTil(new ForeldrepengerSoknad(Fodselsnummer.av("24038815071"), "Astrid", "Berg", 36, "1389", 72_000));
        return register;
    }
}
