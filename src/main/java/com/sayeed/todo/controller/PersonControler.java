package com.sayeed.todo.controller;

import java.util.List;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sayeed.todo.dto.PersonRequestDTO;
import com.sayeed.todo.dto.PersonResponseDTO;
import com.sayeed.todo.service.PersonService;

import lombok.RequiredArgsConstructor;
@RestController 
@RequestMapping("/persons")
@RequiredArgsConstructor
public class PersonControler {
	
	private final PersonService personService;
	
	@PostMapping("/addPerson")
	public PersonResponseDTO savePerson(@RequestBody PersonRequestDTO personRequest) {
		return personService.addPerson(personRequest);
	}
	
	@GetMapping("/getAllPersons")
	public List<PersonResponseDTO> getAllPersons() {
		return personService.getAllPersons();
	}

}
