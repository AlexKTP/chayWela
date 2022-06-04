package com.alexktp.chaywela;

import com.alexktp.chaywela.model.User;
import com.alexktp.chaywela.repository.TaskRepository;
import com.alexktp.chaywela.repository.UserRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;

import java.util.Arrays;


@SpringBootApplication
public class ChaywelaApplication {

	public static void main(String[] args) {
		SpringApplication.run(ChaywelaApplication.class, args);
	}

	@Bean
	CommandLineRunner run(UserRepository userRepository, TaskRepository taskRepository){
		return args -> {
			userRepository.save(new User(null, "alex", "Android and BackEnd dev. I'm currently building a time tracking app. From France."));
		};
	}

	@Bean
	public CorsFilter corsFilter(){
		UrlBasedCorsConfigurationSource cors = new UrlBasedCorsConfigurationSource();
		CorsConfiguration corsConfiguration = new CorsConfiguration();
		corsConfiguration.setAllowCredentials(true);
		corsConfiguration.setAllowedOrigins(Arrays.asList("http://localhost:3000", "http://localhost:4200"));
		corsConfiguration.setAllowedHeaders(Arrays.asList("Origin", "Access-Control-Allow-Origin", "Content-Type",
				"Accept", "Jwt-Token","Authorization", "Origin, Accept", "X-Requested-With","Access-Control-Request-Method",
				"Access-Control-Request-Method"));
		corsConfiguration.setExposedHeaders(Arrays.asList("Origin", "Content-Type", "Jwt-Token", "Accept", "Authorization",
				"Access-Control-Allow-Origin", "Access-Control-Allow-Credentials", "Filename"));
		corsConfiguration.setAllowedMethods(Arrays.asList("GET", "POST", "DELETE", "PATCH", "PUT", "OPTIONS"));
		cors.registerCorsConfiguration("/**", corsConfiguration);
		return new CorsFilter(cors);
	}
}
