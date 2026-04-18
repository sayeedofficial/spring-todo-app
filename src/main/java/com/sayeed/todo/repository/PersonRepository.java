package com.sayeed.todo.repository;

import com.sayeed.todo.entity.Person;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.UUID;

public interface PersonRepository extends JpaRepository<Person, UUID> {

    // Used to convert email → UUID (Person)
    Optional<Person> findByEmail(String email);
}