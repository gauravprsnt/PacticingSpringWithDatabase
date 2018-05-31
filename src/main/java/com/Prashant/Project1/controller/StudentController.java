package com.Prashant.Project1.controller;

import com.Prashant.Project1.service.StudentService;
import com.Prashant.Project1.dto.StudentDto;
import com.Prashant.Project1.modal.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value = "/api")
public class StudentController {
    private final StudentService studentService;

    @Autowired
    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @GetMapping(value = "/students")
    public List<Student> showData(){
    return studentService.findAllStudent();

    }
    @GetMapping(value = "/students/{id}")
    public Optional<Student> getIndividual(@PathVariable(value = "id")Long studentId){
        return studentService.findIndividual(studentId);

    }
    @PostMapping(value="/students")
    public Student insertStudent(@RequestBody  StudentDto studentDto){
        return studentService.insertRecord(studentDto);
    }

    @PutMapping(value = "/students/{id}")
    public Student updateStudent(@PathVariable(value = "id")Long studentId,
                                 @RequestBody StudentDto studentDto){
        return studentService.updateIndividual(studentId,studentDto);
    }

    @PutMapping(value = "/students/{id}/delete")
    public Student updateStatus(@PathVariable(value = "id")Long studentId,
                                @RequestBody StudentDto studentDto){
        return studentService.updateIndividualStatus(studentId,studentDto);
    }



}
