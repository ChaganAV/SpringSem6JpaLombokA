package com.example.springSem6JPALombok.services;

import com.example.springSem6JPALombok.model.Note;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * интерфейс сервиса заметок
 */
public interface NoteService {
    /**
     * выборка всех заметок
     * @return список заметок
     */
    List<Note> getAllNotes();

    /**
     * получение заметки по ИД
     * @param id
     * @return заметка Note
     */
    Note findById(Long id);

    /**
     * создание заметки
     * @param note
     * @return заметка
     */
    Note createNote(Note note);

    /**
     * Изменение заметки
     * @param note
     * @return заметка
     */
    Note updateNote(Note note);

    /**
     * удаление заметки по ИД
     * @param id
     */
    void deleteNote(Long id);
}
