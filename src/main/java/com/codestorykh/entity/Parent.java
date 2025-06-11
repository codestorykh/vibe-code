package com.codestorykh.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name = "my_parent")
public class Parent extends Person {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Long userId; // Foreign key to User entity
}
