package com.codestorykh.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name = "my_teacher")
public class Teacher extends Person {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Long userId; // Foreign key to User entity
    private String department;
    private String subject;
}
