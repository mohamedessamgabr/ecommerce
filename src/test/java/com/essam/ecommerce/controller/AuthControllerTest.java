package com.essam.ecommerce.controller;

import com.essam.ecommerce.dto.auth.AuthenticationRequest;
import com.essam.ecommerce.dto.auth.RegisterRequest;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class AuthControllerTest {

    @Autowired
    TestRestTemplate restTemplate;


    @Test
    void registerIsOkTest() {
        var user = RegisterRequest
                .builder()
                .email("aabb@email.com")
                .firstName("Aa")
                .lastName("Bb")
                .role("ROLE_USER")
                .password("123456")
                .build();

        ResponseEntity<String> response = restTemplate.postForEntity("/v1/auth/register", user, String.class);
        Assertions.assertThat(response.getStatusCode()).isEqualTo(HttpStatus.OK);
        assertEquals(HttpStatus.OK, response.getStatusCode());
    }

    @Test
    void authenticateIsOkTest() {
        var authenticationRequest = AuthenticationRequest
                .builder()
                .email("aabb@email.com")
                .password("123456")
                .build();

        ResponseEntity<String> response = restTemplate.postForEntity("/v1/auth/authenticate", authenticationRequest, String.class);
        Assertions.assertThat(response.getStatusCode()).isEqualTo(HttpStatus.OK);
        assertEquals(HttpStatus.OK, response.getStatusCode());
    }

    @Test
    void authenticateIsNotOkTest() {
        var authenticationRequest = AuthenticationRequest
                .builder()
                .email("aabb@email.com")
                .password("1234561234567")
                .build();

        ResponseEntity<String> response = restTemplate.postForEntity("/api/v1/auth/authenticate", authenticationRequest, String.class);
        Assertions.assertThat(response.getStatusCode()).isEqualTo(HttpStatus.FORBIDDEN);
        assertEquals(HttpStatus.FORBIDDEN, response.getStatusCode());
    }


}