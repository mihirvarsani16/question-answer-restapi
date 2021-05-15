package com.restapi.restapi.repository;

import java.util.List;

import com.restapi.restapi.entity.Question_like;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface Question_likeRepository extends JpaRepository<Question_like, Long> {

    @Query("from Question_like as q where q.questions.qaid =:id")
    public List<Question_like> findQuestion_likesByQuestions(@Param("id") Long id);

}
