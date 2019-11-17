package com.bilgeadam.springboot.courseapp.service;

import com.bilgeadam.springboot.courseapp.dto.CourseRequest;
import com.bilgeadam.springboot.courseapp.model.Course;

import java.util.List;

public interface CourseService {

    List<Course> getAllCourses(Long topicId);

    Course getCourse(Long id);

    Course addCourse(Course course);

    Course updateCourse(Course course, CourseRequest courseRequest);

    void deleteCourse(Long id);
}
