package org.jotsna.controller;

import java.util.Map;

import org.jotsna.dto.UserDTO;
import org.jotsna.entity.User;
import org.jotsna.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
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
        String result  = userService.saveUser(user);
		return result;

	}
	
	@GetMapping("/fetch/{id}")
	public Object getUser(@PathVariable Long id) {
		UserDTO userDTO = (UserDTO)userService.getUser(id);
		if(!userDTO.isActive()) {
			return new UserDTO("user is deactived you can not access");
		}
		return userDTO;
	}
	
	@PutMapping("/update/{id}")
	public String updateUser(@PathVariable Long id,@RequestBody User user ) {
		String result = userService.updateUser(id,user);
		return result;
	}
	@DeleteMapping("/delete/{id}")
	public String deleteUser(@PathVariable Long id) {
		String result = userService.deleteUser(id);
		return result;
	}
}

