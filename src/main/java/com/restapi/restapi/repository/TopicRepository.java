package com.restapi.restapi.repository;

import com.restapi.restapi.entity.Topic;

import org.springframework.data.jpa.repository.JpaRepository;

public interface TopicRepository extends JpaRepository<Topic, Long> {

    public Topic findTopicBytid(Long id);

}
