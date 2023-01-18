package com.dovhopolyi.noteservice.repository;

import com.dovhopolyi.noteservice.dto.Person;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PersonRepo extends JpaRepository<Person,Long> {
    Optional<Person> findByNameAndSurname(String name, String surname);
}
