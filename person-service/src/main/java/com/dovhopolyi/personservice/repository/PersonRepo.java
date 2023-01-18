package com.dovhopolyi.personservice.repository;

import com.dovhopolyi.personservice.dto.Person;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PersonRepo extends JpaRepository<Person,Long> {
}
