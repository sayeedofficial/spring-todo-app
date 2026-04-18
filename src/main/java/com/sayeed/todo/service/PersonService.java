package com.sayeed.todo.service;

import com.sayeed.todo.dto.PersonRequestDTO;
import com.sayeed.todo.dto.PersonResponseDTO;
import com.sayeed.todo.entity.Person;
import com.sayeed.todo.repository.PersonRepository;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PersonService {
	
    private final PersonRepository personRepository;

    public PersonResponseDTO addPerson(PersonRequestDTO personRequestDTO) {

        // Normalize email
        String email = personRequestDTO.getEmail().toLowerCase();

        // Check duplicate
        personRepository.findByEmail(email).ifPresent(p -> {
            throw new RuntimeException("Email already exists");
        });

        // DTO → Entity
        Person newPerson = Person.builder()
                .firstName(personRequestDTO.getFirstName())
                .lastName(personRequestDTO.getLastName())
                .email(email)
                .build();

        Person savedPerson = personRepository.save(newPerson);

        // Entity → DTO
        return PersonResponseDTO.builder()
                .id(savedPerson.getId())
                .firstName(savedPerson.getFirstName())
                .lastName(savedPerson.getLastName())
                .email(savedPerson.getEmail())
                .createdAt(savedPerson.getCreatedAt())
                .build();
    }
}