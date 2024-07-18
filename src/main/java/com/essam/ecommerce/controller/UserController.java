package com.essam.ecommerce.controller;

import com.essam.ecommerce.dto.UserDTO;
import com.essam.ecommerce.service.impl.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/v1/users")
public class UserController extends SimpleCrudController<UserDTO, UserDTO, UserService> {

    @Autowired
    public UserController(UserService service) {
        super(service);
    }

}
