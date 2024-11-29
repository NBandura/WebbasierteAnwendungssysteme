package edu.fra.uas;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.boot.CommandLineRunner;

@SpringBootApplication
public class CounterServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(CounterServiceApplication.class, args);
	}

	@Bean
	CommandLineRunner init(){
		CommandLineRunner action = new CommandLineRunner() {
			@Override
			public void run(String... args) throws Exception {
				System.out.println("Hello World");
			}
		};
		return action;
	}


}
