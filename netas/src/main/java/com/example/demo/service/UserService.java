package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.User;
import com.example.demo.repository.UserRepository;

@Service
public class UserService {

	@Autowired
	UserRepository userRepository;

	public User createUser(User user) {
		userRepository.save(user);
		return user;
	}
	
	public List<User> viewUser(User user) {
		return userRepository.findAll();
	}

	public User updateUser(User user) {
		userRepository.save(user);
		return user;
	}
	
	public User deleteUser(User user) {
		userRepository.delete(user);
		return user;
	}
}
