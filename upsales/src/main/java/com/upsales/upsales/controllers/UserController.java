package com.upsales.upsales.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.upsales.upsales.models.User;
import com.upsales.upsales.requests.CreateUserRequest;
import com.upsales.upsales.responses.BasicResponse;
import com.upsales.upsales.services.UserService;

@RestController
@RequestMapping("/api/users")
public class UserController {
    @Autowired
    private UserService userService;
    @PostMapping("/")
    public @ResponseBody ResponseEntity<?> store(CreateUserRequest userRequest) {
        User response = userService.create(userRequest);

        return new ResponseEntity<>(new BasicResponse("user created successfully", "000", response), HttpStatus.OK);

    }
}
