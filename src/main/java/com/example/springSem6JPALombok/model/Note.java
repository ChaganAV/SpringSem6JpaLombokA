package com.example.springSem6JPALombok.model;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.time.LocalDateTime;

/**
 * модель заметки
 */
@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class Note {
    /**
     * уникальный номер
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    /**
     * заголовок
     */
    @NonNull
    private String title;
    /**
     * описание
     */
    @NonNull
    private String description;
    private LocalDateTime dateBegin = LocalDateTime.now();
}
