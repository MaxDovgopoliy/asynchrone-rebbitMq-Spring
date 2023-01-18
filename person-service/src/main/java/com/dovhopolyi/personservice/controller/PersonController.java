package com.dovhopolyi.personservice.controller;

import com.dovhopolyi.personservice.dto.Person;
import com.dovhopolyi.personservice.dto.UpdateEntity;
import com.dovhopolyi.personservice.service.PersonService;
import lombok.RequiredArgsConstructor;
import org.springframework.cloud.stream.function.StreamBridge;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/persons")
public class PersonController {
    private final PersonService personService;

    @PutMapping("/{id}")
    public Person updatePerson(@PathVariable Long id, @RequestBody Person person) {

        return personService.updatePerson(id,person);

    }
    @GetMapping("/{id}")
    public Person updatePerson(@PathVariable Long id) {
        return personService.findById(id);
    }

    @PostMapping()
    public Person savePerson(@RequestBody Person person) {
        return personService.save(person);
    }
}
