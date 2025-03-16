package org.jotsna.controller;

import java.util.Map;

import org.jotsna.dto.UserDTO;
import org.jotsna.entity.User;
import org.jotsna.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/user")
public class UserController {

	@Autowired
	private final UserService userService;

	public UserController(UserService userService) {

		this.userService = userService;
	}

	@PostMapping("/register")
	public String saveUser(@RequestBody User user) {

		return userService.saveUser(user);

	}
	
	@GetMapping("/fetch/{id}")
	public UserDTO getUser(@PathVariable Long id) {
		return userService.getUser(id);
	}
}

