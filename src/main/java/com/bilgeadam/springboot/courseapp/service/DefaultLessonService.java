package com.bilgeadam.springboot.courseapp.service;

import com.bilgeadam.springboot.courseapp.dto.LessonRequest;
import com.bilgeadam.springboot.courseapp.model.Lesson;
import com.bilgeadam.springboot.courseapp.repository.LessonRepository;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import javax.transaction.Transactional;
import java.util.List;

@Service
public class DefaultLessonService implements LessonService {

    private LessonRepository lessonRepository;

    public DefaultLessonService(LessonRepository lessonRepository) {
        this.lessonRepository = lessonRepository;
    }

    @Override
    public List<Lesson> getAllLessons(Long courseId) {
        return lessonRepository.findByCourseId(courseId);
    }

    @Override
    public Lesson getLesson(Long id) {

        return lessonRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("Lesson not found" + id));
    }

    @Transactional
    @Override
    public Lesson addLesson(Lesson lesson) {
        return lessonRepository.save(lesson);
    }

    @Transactional
    @Override
    public Lesson updateLesson(Lesson lesson, LessonRequest lessonRequest) {
        lesson.setName(lessonRequest.getName());
        lesson.setDescription(lessonRequest.getDescription());
        return lessonRepository.save(lesson);
    }

    @Transactional
    @Override
    public void deleteLesson(Long id) {
        lessonRepository.deleteById(id);

    }
}

