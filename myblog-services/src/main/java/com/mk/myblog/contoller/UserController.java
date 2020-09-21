package com.mk.myblog.contoller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mk.myblog.dto.User;
import com.mk.myblog.service.UserService;

@RestController
@RequestMapping(value = "/user")
public class UserController {

	@Autowired
	private UserService userService;

	@GetMapping
	public List<User> fetchUsers() {
		return userService.fetchUsers();
	}

	@GetMapping(value = "/{id}")
	public User fetchUser(@PathVariable("id") final Integer userId) {
		return userService.fetchUser(userId);
	}

	@PutMapping(value = "/{id}")
	public User updateUser(@PathVariable("id") final Integer userId, @RequestBody final User user) {
		return userService.updateUser(userId, user);
	}

	@PostMapping(value = "/registration")
	public User registerUser(@RequestBody User user) {
		return userService.registerUser(user);
	}

}
