package com.dovhopolyi.noteservice.repository;

import com.dovhopolyi.noteservice.dto.Note;
import org.springframework.data.jpa.repository.JpaRepository;

public interface NoteRepo extends JpaRepository<Note,Long> {
}
