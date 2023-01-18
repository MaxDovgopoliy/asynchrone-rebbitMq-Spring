package com.dovhopolyi.personservice.service;

import com.dovhopolyi.personservice.dto.Person;
import com.dovhopolyi.personservice.dto.UpdateEntity;
import com.dovhopolyi.personservice.repository.PersonRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.cloud.stream.function.StreamBridge;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PersonService {
    private final PersonRepo personRepo;
    private final StreamBridge streamBridge;
    public Person updatePerson(Long id, Person person) {
        Person personFromDb = personRepo.findById(id).orElseThrow();
        personFromDb.setName(person.getName());
        personFromDb.setSurname(person.getSurname());
        personRepo.save(personFromDb);
        streamBridge.send("person-update",new UpdateEntity(personFromDb.getId()));
        return personFromDb;
    }

    public Person findById(Long id) {
        return personRepo.findById(id).orElseThrow();
    }

    public Person save(Person person) {
        return personRepo.save(person);
    }
}
