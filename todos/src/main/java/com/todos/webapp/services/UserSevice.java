package com.todos.webapp.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.todos.webapp.repositories.UserRepository;

@Service
public class UserSevice {
	@Autowired
    private UserRepository userRepository;
}
