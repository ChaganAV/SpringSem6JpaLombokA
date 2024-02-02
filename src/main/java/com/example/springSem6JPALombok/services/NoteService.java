package com.example.springSem6JPALombok.services;

import com.example.springSem6JPALombok.model.Note;
import org.springframework.stereotype.Service;

import java.util.List;

public interface NoteService {
    List<Note> getAllNotes();
    Note getNoteById(Long id);
    Note createNote(Note note);
    Note updateNote(Note note);
    void deleteNote(Long id);
}
