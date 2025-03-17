package org.jotsna.dto;

import java.time.LocalDateTime;

public class UserDTO {
	
	private String name;
	private boolean active;
	private LocalDateTime registeredAt;
	private String string;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public boolean isActive() {
		return active;
	}
	public void setActive(boolean active) {
		this.active = active;
	}
	public LocalDateTime getRegisteredAt() {
		return registeredAt;
	}
	public void setRegisteredAt(LocalDateTime registeredAt) {
		this.registeredAt = registeredAt;
	}
	public UserDTO(String name, boolean active, LocalDateTime registeredAt) {
		
		this.name = name;
		this.active = active;
		this.registeredAt = registeredAt;
	}
	public UserDTO() {
		
	}
	public UserDTO(String string) {
		
		this.string=string;
	}
	

}
