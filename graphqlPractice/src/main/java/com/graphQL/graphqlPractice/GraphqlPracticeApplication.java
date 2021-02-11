package com.graphQL.graphqlPractice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories(basePackages = "com.perennialsys.graphqlPractice.repository")
@EntityScan(basePackages = "com.perennialsys.graphqlPractice.model")
@ComponentScan(basePackages = "com.perennialsys.graphqlPractice.*")
public class GraphqlPracticeApplication {

	public static void main(String[] args) {
		SpringApplication.run(GraphqlPracticeApplication.class, args);
	}

}
