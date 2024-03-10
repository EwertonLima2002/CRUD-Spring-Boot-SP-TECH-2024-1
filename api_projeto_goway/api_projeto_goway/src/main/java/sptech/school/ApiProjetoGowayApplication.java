package sptech.school;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories(basePackages = "sptech.school.api_projeto_goway.Service")
@EntityScan(basePackages = "sptech.school.api_projeto_goway.Model")
@ComponentScan(basePackages = "sptech.school.api_projeto_goway")
public class ApiProjetoGowayApplication {

	public static void main(String[] args) {

		SpringApplication.run(ApiProjetoGowayApplication.class, args);
	}

}
