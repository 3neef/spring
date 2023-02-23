package com.upsales.upsales.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.upsales.upsales.models.User;
import com.upsales.upsales.repos.UserRepository;
import com.upsales.upsales.requests.CreateUserRequest;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    public User create(CreateUserRequest userRequest) {
        User user = new User(0, userRequest.getFullName(),userRequest.getEmail(), userRequest.getPassword(), userRequest.getUserName());

        User result = userRepository.save(user);

        return result;
    }


}
