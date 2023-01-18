package com.dovhopolyi.noteservice.service;

import com.dovhopolyi.noteservice.dto.Person;
import com.dovhopolyi.noteservice.repository.PersonRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

@Service
@RequiredArgsConstructor
public class PersonClientService {
    private RestTemplate restTemplate= new RestTemplate();
    private final PersonRepo personRepo;
    private final WebClient webClient = WebClient.builder().baseUrl("http://localhost:8082").build();
    public  void SynchronizePersonById(Long personId){
        System.out.println("---------->"+personId);
        Person person = restTemplate.getForObject("http://localhost:8082/persons/1", Person.class);
        assert person != null;
        personRepo.save(person);
    }

    public void savePerson(Person person) {
        Person block = webClient
                .post().uri("/persons")
                .header(HttpHeaders.CONTENT_TYPE, String.valueOf(MediaType.APPLICATION_JSON))
                .body(Mono.just(person), Person.class)
                .retrieve().bodyToMono(Person.class).block();
        System.out.println(block);
    }
}
