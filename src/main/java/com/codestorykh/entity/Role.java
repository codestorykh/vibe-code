package com.codestorykh.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name = "my_role")
public class Role {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name; // e.g., ROLE_STUDENT, ROLE_TEACHER
}

