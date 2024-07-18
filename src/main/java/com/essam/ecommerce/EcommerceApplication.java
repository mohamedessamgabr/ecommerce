package com.essam.ecommerce;

import com.essam.ecommerce.entity.Role;
import com.essam.ecommerce.repository.RoleRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

import java.util.List;

@SpringBootApplication
@EnableJpaAuditing
public class EcommerceApplication {

	public static void main(String[] args) {
		SpringApplication.run(EcommerceApplication.class, args);
	}

	@Bean
	public CommandLineRunner commandLineRunner(RoleRepository roleRepository) {
		return  (args) -> {
			List<Role> roles = List.of(
					Role.builder().name("ROLE_USER").build(),
					Role.builder().name("ROLE_ADMIN").build()
			);
			roles.stream()
					.filter(r -> roleRepository.findByName(r.getName()).isEmpty())
					.forEach(roleRepository::save);
		};
	}

}
