package com.odde.hangman;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class HelloWorldControllerTest {

    @Test
    public void should_go_to_index() {
        HelloWorldController controller = new HelloWorldController();

        assertThat(controller.dashboard()).isEqualTo("index");
    }
}
