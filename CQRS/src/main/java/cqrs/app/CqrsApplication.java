package cqrs.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@ComponentScan(basePackages = { "cqrs.app.*"},basePackageClasses = cqrs.app.config.AggregatorRepository.class)

@EnableJpaRepositories(basePackages = { "cqrs.app.repository" })
@EnableAutoConfiguration
public class CqrsApplication {
	public static void main(String[] args) {
		SpringApplication.run(CqrsApplication.class, args);
	}
	
}
