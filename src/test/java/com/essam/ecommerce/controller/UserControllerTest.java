package com.essam.ecommerce.controller;

import com.essam.ecommerce.dto.UserDTO;
import com.essam.ecommerce.service.impl.UserService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.web.servlet.MockMvc;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@AutoConfigureMockMvc
class UserControllerTest {

    @Autowired
    MockMvc mockMvc;

    @Autowired
    ObjectMapper objectMapper;

    @MockBean
    UserService userService;


    @Test
    void getAllUsersOkTest() throws Exception {
        var users = List.of(
                UserDTO.builder().email("abc@email.com").firstName("abc").build(),
                UserDTO.builder().email("def@email.com") .firstName("def").build(),
                UserDTO.builder().email("ghi@email.com").firstName("ghi").build(),
                UserDTO.builder().email("jkl@email.com") .firstName("jkl").build()
        );
        Mockito.when(userService.findAll()).thenReturn(users);
        mockMvc.perform(get("/v1/users")
                .contentType("application/json"))
                .andExpect(status().isOk());
        assertArrayEquals(users.toArray(), userService.findAll().toArray());
        assertNotNull(userService.findAll());
        assertEquals(users.size(), userService.findAll().size());
    }

    @Test
    void saveUserOkTest() throws Exception {
        var users = List.of(
                UserDTO.builder().email("abc@email.com").firstName("abc").build(),
                UserDTO.builder().email("def@email.com") .firstName("def").build(),
                UserDTO.builder().email("ghi@email.com").firstName("ghi").build(),
                UserDTO.builder().email("jkl@email.com") .firstName("jkl").build()
        );
        Mockito.when(userService.save(Mockito.any(UserDTO.class))).thenReturn(users.get(0));
        mockMvc.perform(post("/v1/users")
                .contentType("application/json")
                .content(objectMapper.writeValueAsString(users.get(0))))
                .andExpect(status().isOk());
        assertEquals(users.get(0), userService.save(users.get(0)));
    }

}