package com.student.management.service;

import java.util.*;

import com.student.management.dtos.CourseDto;
import com.student.management.repository.CourseRepository;
import com.student.management.model.Course;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CourseService {

    private final CourseRepository courseRepository;

    public List<CourseDto> getCourses() {
        List<CourseDto> courseDtos = new ArrayList<>();
        courseRepository.findAll().forEach(it -> courseDtos.add(getCourseDtoInstance(it)));
        return courseDtos;
    }

    public List<CourseDto> getCoursesBySemester(int semester) {
        List<CourseDto> courseDtos = new ArrayList<>();
        courseRepository.findBycourseSemester(semester).forEach(it -> courseDtos.add(getCourseDtoInstance(it)));
        return courseDtos;
    }

    public CourseDto getCourse(int id) {
        Optional<Course> course = courseRepository.findById(id);
        return course.map(this::getCourseDtoInstance).orElseGet(CourseDto::new);
    }

    public CourseDto addCourse(CourseDto courseDto) {
        Course course = getCourseInstanceFromDto(courseDto);
        return getCourseDtoInstance(courseRepository.save(course));
    }

    public CourseDto updateCourse(CourseDto courseDto) {
        Course course = getCourseInstanceFromDto(courseDto);
        return getCourseDtoInstance(courseRepository.save(course));
    }

    public void deleteCourse(int id) {
        courseRepository.deleteById(id);
    }

    private Course getCourseInstanceFromDto(CourseDto courseDto) {
        Course course = new Course();
        course.setCourseId(courseDto.getCourseId());
        course.setCourseName(courseDto.getCourseName());
        course.setCourseSemester(courseDto.getCourseSemester());
        return course;
    }

    private CourseDto getCourseDtoInstance(Course course) {
        if(course == null) return new CourseDto();
        CourseDto courseDto = new CourseDto();
        courseDto.setCourseId(course.getCourseId());
        courseDto.setCourseName(course.getCourseName());
        courseDto.setCourseSemester(course.getCourseSemester());
        return courseDto;
    }

}
