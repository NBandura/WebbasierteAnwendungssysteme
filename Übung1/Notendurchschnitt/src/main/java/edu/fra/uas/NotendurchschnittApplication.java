package edu.fra.uas;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import edu.fra.uas.Controller.NotenController;


@SpringBootApplication
public class NotendurchschnittApplication {

	public static void main(String[] args) {
		SpringApplication.run(NotendurchschnittApplication.class, args);
	}

	@Autowired
	private NotenController notenController;

	@Bean
	CommandLineRunner init(){
		CommandLineRunner action = new CommandLineRunner() {
			@Override
			public void run(String... args) throws Exception {
				notenController.addNote(2);
				notenController.addNote(1);
				notenController.addNote(3);
				System.out.println("Durchschnitt: " + notenController.getDurchschnitt());
			}
		};
		return action;
	}

}
