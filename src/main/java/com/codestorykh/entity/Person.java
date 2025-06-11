package com.codestorykh.entity;

import jakarta.persistence.MappedSuperclass;
import lombok.Data;

@Data
@MappedSuperclass
public class Person {

    private String firstName;
    private String lastName;
    private String gender;
    private String birthDate;
    private String placeOfBirth;
    private String phone;
    private String address;
}
