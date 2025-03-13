package org.jotsna.controller;

import org.jotsna.entity.User;
import org.jotsna.service.UserService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/user")
public class UserController {
	
	private final  UserService userService;
	public UserController(UserService userService) {
		
		this.userService=userService;
	}
	
	@GetMapping("/register")
	public String saveUser( @RequestBody User user) {
		
		
		return userService.saveUser(user);
		
	}

}
