package com.codestorykh.entity;

import com.codestorykh.enumz.RoleType;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.Set;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "my_users")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
public class User extends Person{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String username;
    private String email;
    private String password;

    @Enumerated(EnumType.STRING)
    private RoleType role;

    @ToString.Exclude
    @ManyToMany(fetch = FetchType.EAGER)
    private Set<Role> roles;
}
