package com.alexktp.chaywela;

import com.alexktp.chaywela.enums.Status;
import com.alexktp.chaywela.model.Task;
import com.alexktp.chaywela.model.User;
import com.alexktp.chaywela.repository.TaskRepository;
import com.alexktp.chaywela.repository.UserRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.time.LocalDateTime;

@SpringBootApplication
public class ChaywelaApplication {

	public static void main(String[] args) {
		SpringApplication.run(ChaywelaApplication.class, args);
	}

	@Bean
	CommandLineRunner run(UserRepository userRepository, TaskRepository taskRepository){
		return args -> {
			userRepository.save(new User(null, "alex"));
			taskRepository.save(new Task(null, "first", "first", LocalDateTime.now(), LocalDateTime.now(), Status.STARTED, 1L, 1, 10, 1L, 2L));
		};
	}
}
