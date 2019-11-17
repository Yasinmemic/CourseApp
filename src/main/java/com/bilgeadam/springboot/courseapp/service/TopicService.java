package com.bilgeadam.springboot.courseapp.service;

import com.bilgeadam.springboot.courseapp.dto.TopicRequest;
import com.bilgeadam.springboot.courseapp.model.Topic;

import java.util.List;

public interface TopicService {

    List<Topic> getAllTopics();

    Topic getTopic(Long id);

    Topic addTopic(Topic topic);

    Topic updateTopic(Topic topic, TopicRequest topicRequest);

    void deleteTopic(Long id);
}
