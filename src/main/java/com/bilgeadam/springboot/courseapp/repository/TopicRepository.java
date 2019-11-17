package com.bilgeadam.springboot.courseapp.repository;

import com.bilgeadam.springboot.courseapp.model.Topic;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TopicRepository extends CrudRepository<Topic, Long> {
}
