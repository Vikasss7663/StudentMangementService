package com.student.management.repository;

import java.util.List;

import com.student.management.model.Student;

import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepository extends JpaRepository<Student, Integer> {
    
    List<Student> findBystudentSemester(int semester);

    List<Student> findBystudentYear(int year);

    Student findBystudentName(String name);

}
