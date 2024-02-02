package com.example.springSem6JPALombok.repositories;

import com.example.springSem6JPALombok.model.Note;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

/**
 * репозиторий заметок
 * расширяет JPA, с CRUD методами
 */
@Repository
public interface NoteRepository extends JpaRepository<Note, Long> {
    /**
     * поиск заметки по ИД
     * @param id
     * @return значение с учетом, что заметка может быть не найдена
     */
    public Optional<Note> findById(Long id);
}
