package com.essam.ecommerce.service;

import com.essam.ecommerce.entity.User;
import com.essam.ecommerce.repository.UserRepository;
import com.essam.ecommerce.service.impl.UserService;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.test.context.TestPropertySource;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class UserServiceTest {
    @Autowired
    UserService userService;

    @MockBean
    UserRepository userRepository;

    @Test
    void loadUserByUsernameDoesNotThrowUsernameNotFoundExceptionTest() {
         Optional<User> userParam = Optional.of(User.builder()
                .id(1)
                .email("aa@email.com")
                .password("123444")
                .firstName("A")
                .lastName("B")
                .build());
        Mockito.when(userRepository.findByEmail("aa@email.com")).thenReturn(userParam);
        assertDoesNotThrow(() -> {
            ((User) userService.loadUserByUsername("aa@email.com")).getEmail();
        }, "User not found!");
    }

    @Test
    void loadUserByUsernameThrowsUsernameNotFoundExceptionTest() {
        Optional<User> userParam = Optional.of(User.builder()
                .id(1)
                .email("aa@email.com")
                .password("123444")
                .firstName("A")
                .lastName("B")
                .build());
        Mockito.when(userRepository.findByEmail("aa@email.com")).thenReturn(userParam);
        assertThrows(UsernameNotFoundException.class, () -> {
            ((User) userService.loadUserByUsername("aaaaaaaaaaaaaaaaa@email.com")).getEmail();
        }, "User not found!");
    }

}