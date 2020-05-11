package com.cognizant.MentorsConnectAssignment;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication(scanBasePackages="com.cognizant")
@EntityScan("com.cognizant.model")
@EnableJpaRepositories("com.cognizant.repository")
public class MentorsConnectAssignmentApplication {

	public static void main(String[] args) {
		SpringApplication.run(MentorsConnectAssignmentApplication.class, args);
	}

}
