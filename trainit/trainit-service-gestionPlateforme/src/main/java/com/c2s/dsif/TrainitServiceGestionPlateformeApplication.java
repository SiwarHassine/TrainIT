package com.c2s.dsif;

import java.util.ArrayList;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.c2s.dsif.entities.Training;
import com.c2s.dsif.entities.TrainingSession;
import com.c2s.dsif.entities.User;
import com.c2s.dsif.entities.UserRole;
import com.c2s.dsif.repositories.TrainingSessionRepository;
import com.c2s.dsif.service.UserService;

@SpringBootApplication
public class TrainitServiceGestionPlateformeApplication {

	public static void main(String[] args) {
		SpringApplication.run(TrainitServiceGestionPlateformeApplication.class, args);
	}

	@Bean
	public CommandLineRunner start(UserService userService) {
		return (args) -> {
			// save a couple of users
			userService.AddNewRole(new UserRole("User"));
			userService.AddNewRole(new UserRole("Admin"));
			userService.AddNewRole(new UserRole("Manager"));
			userService.AddNewRole(new UserRole("Trainer"));
			userService.AddNewRole(new UserRole("TrainingService"));

			userService.AddNewUser(new User("Jack", "1234", "","13-03-2000","O'Brian"));
			userService.AddNewUser(new User("Chloe", "1234","" ,"13-03-2000","O'Brian"));
			userService.AddNewUser(new User("O'Brian", "1234","" ,"13-03-2000","sam"));
			userService.AddNewUser(new User("Kim", "1234","","13-03-2000","alex"));
			userService.AddNewUser(new User("Michelle", "1234","","13-03-2000","sam"));
			userService.AddNewUser(new User("Palmer", "1234", "","13-03-2000","max"));

			userService.addRoleToUser("Jack", "User");
			userService.addRoleToUser("Chloe", "User");
			userService.addRoleToUser("O'Brian", "Manager");
			userService.addRoleToUser("Kim", "Admin");
			userService.addRoleToUser("Michelle", "TrainingService");
			userService.addRoleToUser("Palmer", "Trainer");

		};
	}

	@Bean
	public CommandLineRunner loadDataTraining(TrainingSessionRepository repository) {
		return (args) -> {
			TrainingSession trainingSession = new TrainingSession("learn Docker");
			Training training = new Training("Docker");
			trainingSession.setTraining(training);
			repository.save(trainingSession);

			TrainingSession trainingSession1 = new TrainingSession("learn Java");
			Training training1 = new Training("java");
			trainingSession1.setTraining(training1);
			repository.save(trainingSession1);

			TrainingSession trainingSession2 = new TrainingSession("learn Spring-boot");
			Training training2 = new Training("Spring-boot");
			trainingSession2.setTraining(training2);
			repository.save(trainingSession2);

		};

	}

}