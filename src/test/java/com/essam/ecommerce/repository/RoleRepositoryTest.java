package com.essam.ecommerce.repository;

import com.essam.ecommerce.entity.Role;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class RoleRepositoryTest {

    @Autowired
    private RoleRepository roleRepository;

    @Test
    void findByNameFoundTest() {
        Optional<Role> roleAdmin = roleRepository.findByName("ROLE_ADMIN");
        Optional<Role> roleUser = roleRepository.findByName("ROLE_USER");
        assertTrue(roleAdmin.isPresent());
        assertTrue(roleUser.isPresent());
    }

    @Test
    void findByNameNotFoundTest() {
        Optional<Role> roleAdmin = roleRepository.findByName("XYZ");
        Optional<Role> roleUser = roleRepository.findByName("ABC");
        assertTrue(roleAdmin.isEmpty());
        assertTrue(roleUser.isEmpty());
    }


}