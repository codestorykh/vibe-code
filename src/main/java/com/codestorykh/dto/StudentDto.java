package com.codestorykh.dto;

import lombok.Data;

@Data
public class StudentDto extends PersonDto{

    private String studentCode;
    private String className;
}
