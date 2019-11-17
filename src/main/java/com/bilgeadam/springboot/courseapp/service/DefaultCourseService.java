package com.bilgeadam.springboot.courseapp.service;

import com.bilgeadam.springboot.courseapp.dto.CourseRequest;
import com.bilgeadam.springboot.courseapp.model.Course;
import com.bilgeadam.springboot.courseapp.repository.CourseRepository;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import javax.transaction.Transactional;
import java.util.List;

@Service
public class DefaultCourseService implements CourseService {

    private CourseRepository courseRepository;

    public DefaultCourseService(CourseRepository courseRepository) {
        this.courseRepository = courseRepository;
    }

    @Override
    public List<Course> getAllCourses(Long topicId) {
        return courseRepository.getCoursesByTopicId(topicId);
    }

    @Override
    public Course getCourse(Long id) {
        return courseRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("Course not found with" + id));
    }

    @Override
    @Transactional
    public Course addCourse(Course course) {
        return courseRepository.save(course);
    }

    @Override
    @Transactional
    public Course updateCourse(Course course, CourseRequest courseRequest) {
        course.setName(courseRequest.getName());
        course.setDescription(courseRequest.getDescription());
        return courseRepository.save(course);
    }

    @Override
    @Transactional
    public void deleteCourse(Long id) {
        courseRepository.deleteById(id);

    }
}
