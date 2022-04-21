package com.student.management.service;

import com.student.management.dtos.SchoolDto;
import com.student.management.model.School;
import com.student.management.model.School;
import com.student.management.repository.SchoolRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class SchoolService {

    private final SchoolRepository schoolRepository;

    public List<School> getSchools() {
        return schoolRepository.findAll();
    }

    public SchoolDto getSchool(int id) {
        return getSchoolDtoInstance(schoolRepository.findById(id).get());
    }

    public SchoolDto addSchool(SchoolDto schoolDto) {
        School school = getSchoolInstanceFromDto(schoolDto);
        return getSchoolDtoInstance(schoolRepository.save(school));
    }

    public SchoolDto updateSchool(SchoolDto schoolDto) {
        School school = getSchoolInstanceFromDto(schoolDto);
        return getSchoolDtoInstance(schoolRepository.save(school));
    }

    public void deleteSchool(int id) {
        schoolRepository.deleteById(id);
    }

    private School getSchoolInstanceFromDto(SchoolDto schoolDto) {
        School school = new School();
        school.setSchoolId(schoolDto.getSchoolId());
        school.setSchoolName(schoolDto.getSchoolName());
        return school;
    }

    private SchoolDto getSchoolDtoInstance(School school) {
        if(school == null) return new SchoolDto();
        SchoolDto schoolDto = new SchoolDto();
        schoolDto.setSchoolId(school.getSchoolId());
        schoolDto.setSchoolName(school.getSchoolName());
        return schoolDto;
    }

}
