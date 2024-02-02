package com.example.springSem6JPALombok.services;

import com.example.springSem6JPALombok.model.Note;
import com.example.springSem6JPALombok.repositories.NoteRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NoteServiceImpl implements NoteService{
    private final NoteRepository noteRepository;

    public NoteServiceImpl(NoteRepository noteRepository) {
        this.noteRepository = noteRepository;
    }

    @Override
    public List<Note> getAllNotes() {
        return noteRepository.findAll();
    }

    @Override
    public Note getNoteById(Long id) {
        return noteRepository.findById(id).orElseThrow(() -> new RuntimeException("Note not found"));
    }

    @Override
    public Note createNote(Note note) {
        return noteRepository.save(note);
    }

    @Override
    public Note updateNote(Note note) {
        Note testNote = noteRepository.findById((long) note.getId()).orElse(null);
        testNote.setTitle(note.getTitle());
        testNote.setDescription(note.getDescription());
        return noteRepository.save(testNote);
    }

    @Override
    public void deleteNote(Long id) {
        if(getNoteById(id) != null)
            noteRepository.deleteById(id);
    }
}
