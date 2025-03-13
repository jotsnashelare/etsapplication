package org.jotsna.service;

import org.jotsna.entity.User;
import org.jotsna.repository.UserRepository;
import org.springframework.stereotype.Service;
@Service
public class UserService  {
	
	private final UserRepository userRepository;
	
	public UserService(UserRepository userRepository)
	{
		this.userRepository=userRepository;
	}
	
	public String saveUser(User user) {
		
		userRepository.save(user);
		return "user saved successfully";
	}
  
}
