package com.alexktp.chaywela;

import com.alexktp.chaywela.model.User;
import com.alexktp.chaywela.repository.UserRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class ChaywelaApplication {

	public static void main(String[] args) {
		SpringApplication.run(ChaywelaApplication.class, args);
	}

	@Bean
	CommandLineRunner run(UserRepository userRepository){
		return args -> {
			userRepository.save(new User(null, "alex"));
		};
	}
}
