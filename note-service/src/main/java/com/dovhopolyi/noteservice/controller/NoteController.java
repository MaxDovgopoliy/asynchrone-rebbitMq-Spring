package com.dovhopolyi.noteservice.controller;

import com.dovhopolyi.noteservice.dto.Note;
import com.dovhopolyi.noteservice.dto.NoteDto;
import com.dovhopolyi.noteservice.service.NoteService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/notes")
public class NoteController {
    private final NoteService noteService;

//    @PostMapping()
//    public Note updatePerson(@RequestBody NoteDto note) {
//        return noteService.save(note);
//    }
    @PostMapping()
    public void updatePerson(@RequestBody Note note) {
        noteService.save(note);
    }

}
