package com.example.demo;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class DemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

	@Bean
	public CommandLineRunner run(UserRepository userRepository, TaskRepository taskRepository) throws Exception {
		return (String[] args) -> {
			User user1 = new User("user01", "Bob", "handler");
			User user2 = new User("user02", "Jenny", "yoo");
			User user3 = new User("user03", "Nhan", "phung");
			User user4 = new User("user04", "ly", "khoa");

			userRepository.save(user1);
			userRepository.save(user2);
			userRepository.save(user3);
			userRepository.save(user4);

			Task task1 = new Task("addItem", "something to do", 5,user2);

	  		taskRepository.save(task1);
	  		taskRepository.assignToUSer(user1,"addItem");
	  		taskRepository.updateProgress(Progress.IN_PROGRESS.toString(),"addItem");

	  		taskRepository.findAll().forEach(System.out::println);
			userRepository.findAll().forEach(System.out::println);

		};
	}
}
