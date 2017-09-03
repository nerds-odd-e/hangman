package com.odde.hangman.driver;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

@Configuration
public class DriverFactory {

    @Bean(name = "anotherDriver", destroyMethod = "close")
    @Scope("cucumber-glue")
    public Driver anotherDriver() {
        return new Driver();
    }

    @Bean(name = "driver", destroyMethod = "close")
    @Scope("cucumber-glue")
    public Driver driver() {
        return new Driver();
    }
}
