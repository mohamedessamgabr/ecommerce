package com.essam.ecommerce;

import com.essam.ecommerce.entity.Role;
import com.essam.ecommerce.repository.RoleRepository;
import org.junit.jupiter.api.Test;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Bean;
import org.springframework.test.context.TestPropertySource;

import java.util.List;

@SpringBootTest
@TestPropertySource(locations = "classpath:application.yml")
class EcommerceApplicationTests {

	@Test
	void contextLoads() {

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
