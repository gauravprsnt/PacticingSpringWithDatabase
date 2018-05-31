package com.Prashant.Project1.service;

import com.Prashant.Project1.dto.StudentDto;
import com.Prashant.Project1.modal.Student;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;

public interface StudentService{
    List<Student> findAllStudent();

    Optional<Student> findIndividual(Long studentId);

    Student insertRecord(StudentDto studentDto);

    Student updateIndividual(Long studentId, StudentDto studentDto);

    Student updateIndividualStatus(Long studentId, StudentDto studentDto);
}
