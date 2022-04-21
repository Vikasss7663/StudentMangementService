package com.student.management.service;

import com.student.management.dtos.StudentDto;
import com.student.management.model.School;
import com.student.management.model.Student;
import com.student.management.repository.SchoolRepository;
import com.student.management.repository.StudentRepository;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class StudentService {
    
    private final StudentRepository studentRepository;
    private final SchoolRepository schoolRepository;
    private Logger logger = LoggerFactory.getLogger(StudentService.class);


    public List<StudentDto> getStudents() {
        List<StudentDto> studentDtos = new ArrayList<>();
        studentRepository.findAll().forEach(it -> studentDtos.add(getStudentDtoInstance(it)));
        return studentDtos;
    }

    public List<StudentDto> getStudentsBySemester(int semester) {
        List<StudentDto> studentDtos = new ArrayList<>();
        studentRepository.findBystudentSemester(semester).forEach(it -> studentDtos.add(getStudentDtoInstance(it)));
        return studentDtos;
    }

    public List<StudentDto> getStudentsByYear(int year) {
        List<StudentDto> studentDtos = new ArrayList<>();
        studentRepository.findBystudentYear(year).forEach(it -> studentDtos.add(getStudentDtoInstance(it)));
        return studentDtos;
    }

    public StudentDto getStudent(int id) {
        Optional<Student> course = studentRepository.findById(id);
        return course.map(this::getStudentDtoInstance).orElseGet(StudentDto::new);
    }

    public StudentDto addStudent(StudentDto studentDto) {
        Student student = getStudentInstanceFromDto(studentDto);
        School school = schoolRepository.getById(studentDto.getSchoolId());
        student.setSchool(school);

        Student insertedStudent = studentRepository.save(student);
        return getStudentDtoInstance(insertedStudent);
    }

    public StudentDto updateStudent(StudentDto studentDto) {
        Student student = getStudentInstanceFromDto(studentDto);
        School school = schoolRepository.getById(studentDto.getSchoolId());
        student.setSchool(school);

        Student updatedStudent = studentRepository.save(student);
        return getStudentDtoInstance(updatedStudent);
    }

    public void deleteStudent(int id) {
        studentRepository.deleteById(id);
    }


    private Student getStudentInstanceFromDto(StudentDto studentDto) {
        Student student = new Student();
        student.setStudentId(studentDto.getStudentId());
        student.setStudentName(studentDto.getStudentName());
        student.setStudentSemester(studentDto.getStudentSemester());
        student.setStudentYear(studentDto.getStudentYear());
        return student;
    }

    private StudentDto getStudentDtoInstance(Student student) {
        if(student == null) return new StudentDto();
        StudentDto studentDto = new StudentDto();
        studentDto.setStudentId(student.getStudentId());
        studentDto.setStudentName(student.getStudentName());
        studentDto.setStudentSemester(student.getStudentSemester());
        studentDto.setStudentYear(student.getStudentYear());
        studentDto.setSchoolId(student.getSchool().getSchoolId());
        studentDto.setSchoolName(student.getSchool().getSchoolName());
        return studentDto;
    }

}
