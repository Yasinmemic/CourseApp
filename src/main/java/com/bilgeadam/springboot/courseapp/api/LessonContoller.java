package com.bilgeadam.springboot.courseapp.api;

import com.bilgeadam.springboot.courseapp.dto.LessonRequest;
import com.bilgeadam.springboot.courseapp.dto.LessonResponse;
import com.bilgeadam.springboot.courseapp.model.Course;
import com.bilgeadam.springboot.courseapp.model.Lesson;
import com.bilgeadam.springboot.courseapp.service.CourseService;
import com.bilgeadam.springboot.courseapp.service.LessonService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.modelmapper.ModelMapper;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Api(tags = "lessons", description = "Lesson Service")
public class LessonContoller extends BaseController {

    private CourseService courseService;

    private LessonService lessonService;

    public LessonContoller(ModelMapper modelMapper, CourseService courseService, LessonService lessonService) {
        super(modelMapper);
        this.courseService = courseService;
        this.lessonService = lessonService;
    }
    @ApiOperation(tags = {"lessons"}, value = "Get All Lessons in here")
    @RequestMapping(method = RequestMethod.GET, value = "/topics/{topicId}/courses/{courseId}/lessons")
    public List<LessonResponse> getAllLessons(@PathVariable("topicId") Long topicId, @PathVariable("courseId") Long courseId) {

        List<Lesson> lessons = lessonService.getAllLessons(courseId);
        List<LessonResponse> lessonResponses = mapAll(lessons,LessonResponse.class);
        return lessonResponses;
    }


    @RequestMapping(method = RequestMethod.GET, value = "/topics/{topicId}/courses/{courseId}/lessons/{lessonId}")
    public LessonResponse getLesson(@PathVariable("topicId") Long topicId, @PathVariable("courseId") Long courseId, @PathVariable("courseId") Long lessonId) {
        Lesson lesson = lessonService.getLesson(lessonId);
        LessonResponse lessonResponse = map(lesson,LessonResponse.class);
        return lessonResponse;
    }

    @RequestMapping(method = RequestMethod.POST, value = "/topics/{topicId}/courses/{courseId}/lessons", consumes = MediaType.APPLICATION_JSON_VALUE)
    public void addLesson(@RequestBody LessonRequest lessonRequest, @PathVariable("topicId") Long topicId, @PathVariable("courseId") Long courseId) {

        Course course = courseService.getCourse(courseId);
        Lesson lesson = map(lessonRequest, Lesson.class);
        lesson.setCourse(course);
        lessonService.addLesson(lesson);
    }

    @RequestMapping(method = RequestMethod.PUT, value = "/topics/{topicId}/courses/{courseId}/lessons/{lessonId}")
    public void updateLesson(@RequestBody LessonRequest lessonRequest, @PathVariable("topicId") Long topicId, @PathVariable("courseId") Long courseId, @PathVariable("lessonId") Long lessonId) {
        Lesson lesson = lessonService.getLesson(lessonId);
        lessonService.updateLesson(lesson, lessonRequest);
    }

    @RequestMapping(method = RequestMethod.DELETE, value = "topics/{topicId}/courses/{courseId}/lessons/{lessonId}")
    public void deleteLesson(@PathVariable("topicId") Long topicId, @PathVariable("courseId") Long courseId, @PathVariable("lessonId") Long lessonId) {
        lessonService.deleteLesson(lessonId);
    }
}
