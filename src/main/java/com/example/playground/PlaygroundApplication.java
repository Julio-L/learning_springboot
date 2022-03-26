package com.example.playground;

import com.example.playground.models.User;
import com.example.playground.repository.UserRepository;
import com.example.playground.types.JWTManager;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.core.env.Environment;
import org.springframework.core.env.Profiles;

import java.util.ArrayList;

@SpringBootApplication
public class PlaygroundApplication {

	public static void main(String[] args) {
		SpringApplication.run(PlaygroundApplication.class, args);
	}


	@Bean
	public JWTManager jwtManager(){
		return new JWTManager();
	}

	@Bean
	public CommandLineRunner test(UserRepository userRepository){

		return new CommandLineRunner() {
			@Override
			public void run(String... args) throws Exception {
				System.out.println("Hello");
//				userRepository.save(new User("July", new ArrayList()));
			}
		};
	}


}
