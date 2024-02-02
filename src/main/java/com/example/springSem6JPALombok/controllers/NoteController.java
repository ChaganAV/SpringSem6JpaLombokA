package com.example.springSem6JPALombok.controllers;

import com.example.springSem6JPALombok.model.Note;
import com.example.springSem6JPALombok.services.NoteService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

/**
 * рест контроллер по пути /notes
 */
@RestController
@RequestMapping("/notes")
@RequiredArgsConstructor
public class NoteController {
    private final NoteService noteService;

    /**
     * точка для вывода всех заметок
     * @return ответ с Http статусом
     */
    @GetMapping
    public ResponseEntity<List<Note>> getAllNote(){
        return new ResponseEntity<>(noteService.getAllNotes(), HttpStatus.OK);
    }

    /**
     * точка создания заметки
     * @param note
     * @return ответ с Http статусом
     */
    @PostMapping
    public ResponseEntity<Note> createNote(@RequestBody Note note){
        return new ResponseEntity<>(noteService.createNote(note),HttpStatus.OK);
    }

    /**
     * точка получения заметки
     * @param id ИД
     * @return ответ с Http статусом
     */
    @GetMapping("/{id}")
    public ResponseEntity<Note> getNote(@PathVariable("id") Long id){
        Optional<Note> note = Optional.ofNullable(noteService.findById(id));
        if(note == null){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        return new ResponseEntity<>(note.get(),HttpStatus.OK);
    }

    /**
     * точка для изменения заметки
     * @param note
     * @return ответ с Http статусом
     */
    @PutMapping
    public ResponseEntity<Note> updateNote(@RequestBody Note note){
        return new ResponseEntity<>(noteService.updateNote(note),HttpStatus.OK);
    }

    /**
     * точка для удаления заметки по ИД
     * @param id
     * @return ответ пустой
     */
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteNote(@PathVariable("id") Long id){
        noteService.deleteNote(id);
        return ResponseEntity.ok().build();
    }
}
