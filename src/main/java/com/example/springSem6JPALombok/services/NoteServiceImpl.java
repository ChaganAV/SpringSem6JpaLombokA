package com.example.springSem6JPALombok.services;

import com.example.springSem6JPALombok.model.Note;
import com.example.springSem6JPALombok.repositories.NoteRepository;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * сервис имплементирует интерфейс
 */
@Service
@AllArgsConstructor
public class NoteServiceImpl implements NoteService{
    /**
     * репозиторий
     */
    private final NoteRepository noteRepository;

    /**
     * метод выборки всех заметок
     * @return список заметок
     */
    @Override
    public List<Note> getAllNotes() {
        return noteRepository.findAll();
    }

    /**
     * получение заметки по ИД
     * @param id
     * @return заметка
     */
    @Override
    public Note findById(Long id) {
        return noteRepository.findById(id).orElseThrow(() -> new RuntimeException("Note not found"));
    }

    /**
     * создание заметки
     * @param note заметка
     * @return заметка
     */
    @Override
    public Note createNote(Note note) {
        return noteRepository.save(note);
    }

    /**
     * изменение заметки
     * @param note заметка
     * @return заметка
     */
    @Override
    public Note updateNote(Note note) {
        Note testNote = noteRepository.findById((long) note.getId()).orElse(null);
        testNote.setTitle(note.getTitle());
        testNote.setDescription(note.getDescription());
        return noteRepository.save(testNote);
    }

    /**
     * удаление заметки по ИД
     * @param id ИД
     */
    @Override
    public void deleteNote(Long id) {
        if(findById(id) != null)
            noteRepository.deleteById(id);
    }
}
