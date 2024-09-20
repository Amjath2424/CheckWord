package com.amjath.guessthewors.guess_the._word;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class GuessTheWordApplication {

	public static void main(String[] args) {
		ConfigurableApplicationContext configurableApplicationContext  = SpringApplication.run(GuessTheWordApplication.class, args);
	}

}
