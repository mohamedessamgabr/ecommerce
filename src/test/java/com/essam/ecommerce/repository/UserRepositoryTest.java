package com.essam.ecommerce.repository;

import com.essam.ecommerce.entity.User;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.TestPropertySource;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class UserRepositoryTest {

    @MockBean
    UserRepository userRepository;

    @Test
    void findByEmailNotFoundTest() {
        Optional<User> userParam = Optional.of(User.builder()
                .id(1)
                .email("aa@email.com")
                .password("123444")
                .firstName("A")
                .lastName("B")
                .build());
        Mockito.when(userRepository.findByEmail("aa@email.com")).thenReturn(userParam);
        Optional<User> user = userRepository.findByEmail("david@gmail.com");
        assertFalse(user.isPresent());
    }

    @Test
    void findByEmailFoundTest() {
        Optional<User> userParam = Optional.of(User.builder()
                .id(1)
                .email("aa@email.com")
                .password("123444")
                .firstName("A")
                .lastName("B")
                .build());
        Mockito.when(userRepository.findByEmail("aa@email.com")).thenReturn(userParam);
        Optional<User> user = userRepository.findByEmail("aa@email.com");
        assertTrue(user.isPresent());

    }

}