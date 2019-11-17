package com.bilgeadam.springboot.courseapp.repository;

import com.bilgeadam.springboot.courseapp.model.Course;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CourseRepository extends CrudRepository<Course, Long> {
    List<Course> getCoursesByTopicId(Long topicId);

}
