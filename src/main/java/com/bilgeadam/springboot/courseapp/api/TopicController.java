package com.bilgeadam.springboot.courseapp.api;

import com.bilgeadam.springboot.courseapp.dto.TopicRequest;
import com.bilgeadam.springboot.courseapp.dto.TopicResponse;
import com.bilgeadam.springboot.courseapp.model.Topic;
import com.bilgeadam.springboot.courseapp.service.TopicService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.modelmapper.ModelMapper;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Api(tags = "topics", description = "Topic Service")
public class TopicController extends BaseController {

    private TopicService topicService;

    public TopicController(ModelMapper modelMapper, TopicService topicService) {
        super(modelMapper);
        this.topicService = topicService;
    }

    @ApiOperation(tags = {"topics"}, value = "Get All Courses in here")
    @RequestMapping(method = RequestMethod.GET, value = "/topics")
    public List<TopicResponse> getAllTopics() {

        List<Topic> topics = topicService.getAllTopics();
        List<TopicResponse> topicResponses = mapAll(topics, TopicResponse.class);
        return topicResponses;

    }

    @RequestMapping(method = RequestMethod.GET, value = "/topics/{id}")
    public TopicResponse getTopic(@PathVariable("id") Long id) {
        Topic topic = topicService.getTopic(id);
        TopicResponse topicResponse = map(topic, TopicResponse.class);
        return topicResponse;
    }

    @RequestMapping(method = RequestMethod.POST, value = "/topics", consumes = MediaType.APPLICATION_JSON_VALUE)
    public void addTopic(@RequestBody TopicRequest topicRequest) {
        Topic topic = map(topicRequest, Topic.class);
        topicService.addTopic(topic);

    }

    @RequestMapping(method = RequestMethod.PUT, value = "/topics/{id}", consumes = MediaType.APPLICATION_JSON_VALUE)
    public void updateTopic(@RequestBody TopicRequest topicRequest, @PathVariable("id") Long id) {
        Topic topic = topicService.getTopic(id);
        topicService.updateTopic(topic, topicRequest);

    }

    @RequestMapping(method = RequestMethod.DELETE, value = "/topics/{id}")
    public void deleteTopic(@PathVariable("id") Long id) {
        topicService.deleteTopic(id);

    }
}
