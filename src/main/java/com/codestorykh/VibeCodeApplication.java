package com.codestorykh;

import com.codestorykh.dto.PersonDto;
import com.codestorykh.dto.StudentDto;
import com.codestorykh.dto.UserRequest;
import com.codestorykh.enumz.RoleType;
import com.codestorykh.service.UserService;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Set;

@SpringBootApplication
public class VibeCodeApplication {

	public static void main(String[] args) {
		SpringApplication.run(VibeCodeApplication.class, args);
	}

	@Autowired
	UserService userService;


	@PostConstruct
	void init() {

		PersonDto parent = new PersonDto();
		parent.setFirstName("Code");
		parent.setLastName("Student");
		parent.setGender("Male");
		parent.setBirthDate("2000-01-01");
		parent.setPlaceOfBirth("Phnom Penh");
		parent.setPhone("0123456789");


		StudentDto student = new StudentDto();
		student.setFirstName("Code");
		student.setLastName("Student");
		student.setGender("Male");
		student.setBirthDate("2000-01-01");
		student.setPlaceOfBirth("Phnom Penh");
		student.setPhone("0123456789");
		student.setStudentCode("Java101");
		student.setClassName("10A1");

		UserRequest userRequest = new UserRequest();
		userRequest.setParent(parent);
		userRequest.setStudent(student);
		userRequest.setEmail("codestorykh@gmail.com");
		userRequest.setPassword("password");
		userRequest.setUsername("codestorykh");
		userRequest.setRoleType(RoleType.STUDENT);

		userService.createUser(userRequest);
	}

}
