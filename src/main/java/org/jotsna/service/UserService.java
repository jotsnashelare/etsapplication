package org.jotsna.service;

import java.time.LocalDateTime;

import org.jotsna.dto.UserDTO;
import org.jotsna.entity.User;
import org.jotsna.repository.UserRepository;
import org.springframework.stereotype.Service;
import org.jotsna.entity.User;


@Service
public class UserService {

	private final UserRepository userRepository;

	public UserService(UserRepository userRepository) {
		this.userRepository = userRepository;
		

	}

	public String saveUser(User user) {

		userRepository.save(user);
		return "user saved successfully";
	}

	public Object getUser(Long Id) {
		
		
		User user = userRepository.findById(Id).get();
		
		if(user.isActive()) {
			UserDTO userDTO= new UserDTO(user.getName(),user.isActive(),user.getRegisteredAt());
			return userDTO;
		}
		UserDTO userDTO = new UserDTO("user is deactived you can not access");
		
		return userDTO;
	}
	public String updateUser(Long id , User userUpdate) {
		
		User user = userRepository.findById(id).get();
		
		if(!user.isActive())
		{
			return " User is deactived. cannot update";
		}
		if(user.getName()!=null && user.getName().isEmpty())
		{
			user.setName(userUpdate.getName());
			
		}
		if(user.getPassword()!=null && !userUpdate.getPassword().isEmpty())
		{
			if(userUpdate.getPassword().length()<6) {
				return "password must be at list six digits";
			}
			user.setPassword(userUpdate.getPassword());
		}
		userRepository.save(user);
		
		
		return "User updated successfully";
		
	}

	public String deleteUser(Long id) {
		User user = userRepository.findById(id).get();
	     if(!user.isActive())
	     {
	    	 return " user not found";
	     }
	     
	     user.setActive(false);
	     userRepository.save(user);
	     
				return "user deactived successfully";
	}
	
}