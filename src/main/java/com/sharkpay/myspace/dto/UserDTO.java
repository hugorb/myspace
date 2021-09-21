package com.sharkpay.myspace.dto;

import com.sharkpay.myspace.entities.User;

public class UserDTO {
	
	private String id;
	private String name;
	private String email;
	
	public UserDTO() {
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
	public static UserDTO convertToDTO(User user) {
		UserDTO userDTO = new UserDTO();
		userDTO.setEmail(user.getEmail());
		userDTO.setId(user.getId());
		userDTO.setName(user.getName());
		return userDTO;
	}
}
