package com.student.management.controller;

import com.student.management.dtos.StudentDto;
import com.student.management.service.StudentService;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.lang.NonNull;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/student")
@RequiredArgsConstructor
public class StudentController {

    private final StudentService service;
    private Logger logger = LoggerFactory.getLogger(this.getClass());


    // GET ( Get All Students )
    @GetMapping
    public List<StudentDto> getStudents() {
        return service.getStudents();
    }

    // GET ( Get All Students By Semester )
    @GetMapping(value = "semester/{semester}")
    public List<StudentDto> getStudentsBySemester(@PathVariable int semester) {
        return service.getStudentsBySemester(semester);
    }

    // GET ( Get All Students By Year )
    @GetMapping(value = "year/{year}")
    public List<StudentDto> getStudentsByYear(@NonNull @PathVariable int year) {
        return service.getStudentsByYear(year);
    }

    // GET ( Get Student by ID)
    @GetMapping(value = "{id}")
    public StudentDto getStudent(@PathVariable int id, Model model) {
        return service.getStudent(id);
    }

    // POST ( Add Course )
    @PostMapping
    public StudentDto addStudent(@NonNull @RequestBody StudentDto studentDto) {
        StudentDto insertedStudent = service.addStudent(studentDto);
        logger.debug("Inserted Student --> " + insertedStudent);
        return insertedStudent;
    }

    // PUT ( Update Student )
    @PutMapping
    public StudentDto updateStudent(@RequestBody StudentDto studentDto) {
        return service.updateStudent(studentDto);
    }

    // DELETE ( Delete Student )
    @DeleteMapping(value = "{id}")
    public void deleteStudent(@PathVariable int id) {
        service.deleteStudent(id);
    }
    
}
