package com.codestorykh.dto;

import com.codestorykh.enumz.RoleType;
import lombok.Data;


@Data
public class UserRequest {

    private PersonDto parent;
    private StudentDto student;

    private String username;
    private String email;
    private String password;
    private RoleType roleType;

}
