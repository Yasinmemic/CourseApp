package com.bilgeadam.springboot.courseapp.api;

import com.bilgeadam.springboot.courseapp.dto.CourseRequest;
import com.bilgeadam.springboot.courseapp.dto.CourseResponse;
import com.bilgeadam.springboot.courseapp.model.Course;
import com.bilgeadam.springboot.courseapp.model.Topic;
import com.bilgeadam.springboot.courseapp.service.CourseService;
import com.bilgeadam.springboot.courseapp.service.TopicService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.modelmapper.ModelMapper;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Api(tags = "courses", description = "Course Service")
@RestController
public class CourseController extends BaseController {


    private CourseService courseService;
    private TopicService topicService;

    public CourseController(ModelMapper modelMapper, CourseService courseService, TopicService topicService) {
        super(modelMapper);
        this.courseService = courseService;
        this.topicService = topicService;
    }

    @ApiOperation(tags = {"courses"}, value = "Get All Courses in here")
    @RequestMapping(method = RequestMethod.GET, value = "/topics/{id}/courses")
    public List<CourseResponse> getAllCourses(@PathVariable("id") Long id) {
        List<Course> courses = courseService.getAllCourses(id);
        List<CourseResponse> courseResponses = mapAll(courses, CourseResponse.class);
        return courseResponses;
    }


    @RequestMapping(method = RequestMethod.GET, value = "/topics/{topicId}/courses/{courseId}")
    public CourseResponse getCourse(@PathVariable("topicId") Long topicId, @PathVariable("courseId") Long courseId) {
        Course course = courseService.getCourse(courseId);
        CourseResponse courseResponse = map(course, CourseResponse.class);
        return courseResponse;
    }

    @RequestMapping(method = RequestMethod.POST, value = "/topics/{topicId}/courses", consumes = MediaType.APPLICATION_JSON_VALUE)
    public void addCourse(@RequestBody CourseRequest courseRequest, @PathVariable("topicId") Long topicId) {
        Topic topic = topicService.getTopic(topicId);
        Course course = map(courseRequest, Course.class);
        course.setTopic(topic);
        courseService.addCourse(course);
    }

    @RequestMapping(method = RequestMethod.PUT, value = "/topics/{topicId}/courses/{courseId}", consumes = MediaType.APPLICATION_JSON_VALUE)
    public void updateCourse(@RequestBody CourseRequest courseRequest, @PathVariable("topicId") Long topicId, @PathVariable("courseId") Long courseId) {
        Course course = courseService.getCourse(courseId);
        courseService.updateCourse(course, courseRequest);
    }

    @RequestMapping(method = RequestMethod.DELETE, value = "/topics/{topicId}/courses/{courseId}")
    public void deleteCourse(@PathVariable("courseId") Long courseId) {
        courseService.deleteCourse(courseId);
    }
}
