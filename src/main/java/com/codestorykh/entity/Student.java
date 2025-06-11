package com.codestorykh.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name = "my_student")
public class Student extends Person {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Long userId; // Foreign key to User entity
    private Long parentId; // Foreign key to Parent entity

    private String studentCode;
    private String className;
}
