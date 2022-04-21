package com.student.management.dtos;

import lombok.Data;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Data
public class SchoolDto {

    private int schoolId;

    @NotNull(message = "School Name cannot be null")
    @NotEmpty
    private String schoolName;

}
