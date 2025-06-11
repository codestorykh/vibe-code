package com.codestorykh.service;

import java.util.List;
import java.util.Optional;
import java.util.Set;

import com.codestorykh.dto.StudentDto;
import com.codestorykh.dto.UserRequest;
import com.codestorykh.entity.Parent;
import com.codestorykh.entity.Role;
import com.codestorykh.entity.Student;
import com.codestorykh.repository.ParentRepository;
import com.codestorykh.repository.RoleRepository;
import com.codestorykh.repository.StudentRepository;
import org.springframework.stereotype.Service;

import com.codestorykh.entity.User;
import com.codestorykh.repository.UserRepository;

import lombok.RequiredArgsConstructor;
 

@Service
@RequiredArgsConstructor
public class UserService {
	
	private final RoleRepository roleRepository;
    private final ParentRepository parentRepository;
    private final UserRepository userRepository;
    private final StudentRepository studentRepository;


    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    public User getUserById(Long id) {
        Optional<User> user = userRepository.findById(id);
       return user.get();
    }

    public User createUser(UserRequest userRequest) {

        Role role = new Role();
        role.setName(userRequest.getRoleType().name());
        roleRepository.save(role);

        User user = new User();
        user.setRoles(Set.of(role));
        user.setUsername(userRequest.getUsername());
        user.setPassword(userRequest.getPassword());
        user.setEmail(userRequest.getEmail());
        userRepository.save(user);

        var parentDto = userRequest.getParent();
        Parent parent = new Parent();
        parent.setFirstName(parentDto.getFirstName());
        parent.setLastName(parentDto.getLastName());
        parent.setGender(parentDto.getGender());
        parentRepository.save(parent);

        StudentDto studentDto = userRequest.getStudent();
        Student student = new Student();
        student.setFirstName(studentDto.getFirstName());
        student.setLastName(studentDto.getLastName());
        student.setGender(studentDto.getGender());
        student.setBirthDate(studentDto.getBirthDate());
        student.setPlaceOfBirth(studentDto.getPlaceOfBirth());
        student.setUserId(user.getId());
        student.setParentId(parent.getId());
        student.setStudentCode(studentDto.getStudentCode());
        student.setClassName(studentDto.getClassName());

        studentRepository.save(student);

        return null;
    }

    public void deleteUser(Long id) {
        userRepository.deleteById(id);
    }
}
