package com.restapi.restapi.repository;

import java.util.List;

import com.restapi.restapi.entity.Answer;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface AnswerRepository extends JpaRepository<Answer, Long> {

    public Answer findAnswerByaid(Long id);

    @Query("from Answer as a where a.questions.qaid =:id")
    public List<Answer> findAnswerByQuestions(@Param("id") Long id);

}

// public interface CompanyRepository extends JpaRepository<Company, Long> {

// public Company findByCid(Long cid);
// }
