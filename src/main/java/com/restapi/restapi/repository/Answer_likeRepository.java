package com.restapi.restapi.repository;

import java.util.List;

import com.restapi.restapi.entity.Answer_like;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface Answer_likeRepository extends JpaRepository<Answer_like, Long> {

    @Query("from Answer_like as a where a.answer.aid =:id")
    public List<Answer_like> findAnswer_likeByAnswer(@Param("id") Long id);

}
// @Query("from Answer as a where a.questions.qaid =:id")
// public List<Answer> findAnswerByQuestions(@Param("id") Long id);