package com.bilgeadam.springboot.courseapp.service;

import com.bilgeadam.springboot.courseapp.dto.TopicRequest;
import com.bilgeadam.springboot.courseapp.model.Topic;
import com.bilgeadam.springboot.courseapp.repository.TopicRepository;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@Service
public class DefaultTopicService implements TopicService {

    private TopicRepository topicRepository;

    public DefaultTopicService(TopicRepository topicRepository) {
        this.topicRepository = topicRepository;
    }

    @Override
    public List<Topic> getAllTopics() {
        List<Topic> topics = new ArrayList<Topic>();
        topicRepository.findAll().forEach(topics::add);
        return topics;
    }


    @Override
    public Topic getTopic(Long id) {
        return topicRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("Topic not found with " + id));
    }

    @Transactional
    @Override
    public Topic addTopic(Topic topic) {
        return topicRepository.save(topic);
    }

    @Transactional
    @Override
    public Topic updateTopic(Topic topic, TopicRequest topicRequest) {
        topic.setName(topicRequest.getName());
        topic.setDescription(topicRequest.getDescription());
        return topicRepository.save(topic);
    }

    @Transactional
    @Override
    public void deleteTopic(Long id) {
        topicRepository.deleteById(id);

    }
}
