package com.Prashant.Project1.service;

import com.Prashant.Project1.exception.ResourceNotFoundException;
import com.Prashant.Project1.dto.StudentDto;
import com.Prashant.Project1.modal.Status;
import com.Prashant.Project1.modal.Student;
import com.Prashant.Project1.repository.StudentRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StudentServiceImpl implements StudentService {

    private final StudentRepository studentRepository;

    public StudentServiceImpl(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    @Override
    public List<Student> findAllStudent() {
        return studentRepository.findAll();
    }
    @Override
    public Optional<Student> findIndividual(Long studentId) {
        return studentRepository.findById(studentId);
    }

    @Override
    public Student insertRecord(StudentDto studentDto) {
        Student student=new Student();
        student.setName(studentDto.getName());
        student.setAddress(studentDto.getAddress());
        student.setStd(studentDto.getStd());
        student.setStatus(Status.ACTIVE);
        return studentRepository.save(student);
    }

    @Override
    public Student updateIndividual(Long studentId, StudentDto studentDto) {
        Student student=studentRepository.findById(studentId).orElseThrow(()-> new ResourceNotFoundException("Student","id",studentId));
        student.setName(studentDto.getName());
        student.setAddress(studentDto.getAddress());
        student.setStd(studentDto.getStd());
        return studentRepository.save(student);
    }

    @Override
    public Student updateIndividualStatus(Long studentId, StudentDto studentDto) {
        Student student=studentRepository.findById(studentId).orElseThrow(()-> new ResourceNotFoundException("Student","id",studentId));
        student.setStatus(Status.INACTIVE);
        return  studentRepository.save(student);
    }


}
