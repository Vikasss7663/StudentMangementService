package com.student.management.controller;

import com.student.management.dtos.SchoolDto;
import com.student.management.model.School;
import com.student.management.service.SchoolService;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/school")
@RequiredArgsConstructor
public class SchoolController {

    private final SchoolService schoolService;
    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @GetMapping
    public List<School> getSchools() {
        return schoolService.getSchools();
    }

    @GetMapping(value = "{id}")
    public SchoolDto getSchool(@PathVariable int id) {
        return schoolService.getSchool(id);
    }

    @PostMapping
    public SchoolDto addSchool(@RequestBody SchoolDto schoolDto) {
        return schoolService.addSchool(schoolDto);
    }

    @PutMapping
    public SchoolDto updateSchool(@RequestBody SchoolDto schoolDto) {
        return schoolService.addSchool(schoolDto);
    }

    @DeleteMapping(value = "{id}")
    public void deleteSchool(@PathVariable int id) {
        schoolService.deleteSchool(id);
    }



}
