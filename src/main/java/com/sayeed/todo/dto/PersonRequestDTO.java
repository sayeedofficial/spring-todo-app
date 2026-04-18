package com.sayeed.todo.dto;

import jakarta.validation.constraints.*;
import lombok.Data;

@Data
public class PersonRequestDTO {
	
	@NotBlank
	private String firstName;
	
	@NotBlank
	private String lastName;
	
	@Email
	@NotBlank
	private String email;
	

}
