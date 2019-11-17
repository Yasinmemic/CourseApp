package com.bilgeadam.springboot.courseapp.repository;

import com.bilgeadam.springboot.courseapp.model.Lesson;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface LessonRepository extends JpaRepository<Lesson, Long> {

    List<Lesson> findByCourseId(Long id);

}
