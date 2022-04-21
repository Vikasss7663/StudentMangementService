package com.student.management.model;

import lombok.Data;

import javax.persistence.*;
import java.util.Set;

@Data
@Entity
public class School {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int schoolId;
    private String schoolName;

    @OneToMany(mappedBy = "school")
    private Set<Student> students;

}
