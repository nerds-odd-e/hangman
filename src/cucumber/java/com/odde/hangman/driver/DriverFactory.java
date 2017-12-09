package com.odde.hangman.driver;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DriverFactory {

    @Bean(name = "anotherDriver", destroyMethod = "close")
    public Driver anotherDriver() {
        return new Driver();
    }

    @Bean(name = "driver", destroyMethod = "close")
    public Driver driver() {
        return new Driver();
    }
}
