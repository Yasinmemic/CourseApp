package com.bilgeadam.springboot.courseapp.service;

import com.bilgeadam.springboot.courseapp.dto.LessonRequest;
import com.bilgeadam.springboot.courseapp.model.Lesson;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface LessonService {

    List<Lesson> getAllLessons(Long courseId);

    Lesson getLesson(Long lessonId);

    Lesson addLesson(Lesson lesson);

    Lesson updateLesson(Lesson lesson, LessonRequest lessonRequest);

    void deleteLesson(Long id);
}
