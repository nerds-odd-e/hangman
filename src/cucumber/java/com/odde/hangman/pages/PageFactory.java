package com.odde.hangman.pages;

import com.odde.hangman.driver.Driver;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

@Configuration
public class PageFactory {

    @Bean(name = "anotherHomePage")
    @Scope("cucumber-glue")
    public HomePage anotherHomePage(Driver anotherDriver) {
        return new HomePage(anotherDriver);
    }

    @Bean(name = "homePage")
    @Scope("cucumber-glue")
    public HomePage homePage(Driver driver) {
        return new HomePage(driver);
    }
}
