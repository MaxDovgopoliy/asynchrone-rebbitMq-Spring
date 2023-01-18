package com.dovhopolyi.noteservice.service;

import com.dovhopolyi.noteservice.dto.Note;
import com.dovhopolyi.noteservice.dto.NoteDto;
import com.dovhopolyi.noteservice.dto.Person;
import com.dovhopolyi.noteservice.repository.NoteRepo;
import com.dovhopolyi.noteservice.repository.PersonRepo;
import java.util.Optional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class NoteService {
    private final PersonRepo personRepo;
    private final NoteRepo noteRepo;
    private final PersonClientService personClientService;

    public Note save(Note note) {
        Optional<Person> personById = personRepo.findByNameAndSurname(note.getPerson().getName(),
                note.getPerson().getSurname());
        Person person = note.getPerson();
        if (personById.isEmpty()) {
            personClientService.savePerson(person);
            personRepo.save(person);
        } else {
            note.setPerson(personById.get());
        }
        return noteRepo.save(note);
    }
}
