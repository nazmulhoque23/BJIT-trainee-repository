package com.devrezaur.main.model.config;

import com.devrezaur.main.model.Computer;
import com.devrezaur.main.model.Developer;
import com.devrezaur.main.model.implementation.AmdComputer;
import com.devrezaur.main.model.implementation.IntelComputer;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BeanConfig {

    @Bean
    public AmdComputer amdComputer() {
        return new AmdComputer("AMD", "Rygen 7", "1660 Super");
    }

//    @Bean
//    public IntelComputer intelComputer() {
//        return new IntelComputer("Intel", "i7 10th Gen", "32 GB", "1 TB");
//    }

    @Bean
    public Developer developer1(Computer computer) {
        return new Developer("Rezaur Rahman", "Enterprise Java", computer);
    }
}
