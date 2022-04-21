package com.student.management.controller;

import com.student.management.dtos.CourseDto;
import com.student.management.dtos.RegistrationDto;
import com.student.management.dtos.StudentDto;
import com.student.management.service.RegistrationService;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/registration")
@RequiredArgsConstructor
public class RegistrationController {

    private final RegistrationService service;

    // GET ( Get All Courses by Student ID)
    @GetMapping(value = "student/{id}")
    public List<CourseDto> getCoursesByStudentId(@NonNull @PathVariable String id) {
        return service.getCoursesByStudentId(id);
    }

    // GET ( Get All Students by Course ID)
    @GetMapping(value = "course/{id}")
    public List<StudentDto> getStudentsByCourseId(@NonNull @PathVariable String id) {
        return service.getStudentsByCourseId(id);
    }

    // POST ( Add Student )
    @PostMapping(value = "student")
    public RegistrationDto addStudent(@NonNull @RequestBody RegistrationDto registrationDto) {
        return service.addStudent(registrationDto);
    }

}
