package com.restapi.restapi.repository;

import java.util.List;

import com.restapi.restapi.entity.SubTopic;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface SubTopicRepository extends JpaRepository<SubTopic, Long> {

    @Query("from SubTopic as s where s.topic.tid =:id")
    public List<SubTopic> findSubTopicByTopic(@Param("id") Long id);

    public SubTopic findBySid(Long sid);
}
