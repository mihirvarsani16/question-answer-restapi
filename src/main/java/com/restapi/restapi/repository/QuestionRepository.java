package com.restapi.restapi.repository;

import java.util.List;

import com.restapi.restapi.entity.Questions;

import org.springframework.data.jpa.repository.JpaRepository;

public interface QuestionRepository extends JpaRepository<Questions, Long> {

    public Questions findQuestionsByqaid(Long id);

    public List<Questions> findQuestionsBycompanyid(Long id);

    // companyid

    // public List<Questions> findAllById(Long id);

    // @Query("select q from Questions q where q.company.cid =:id")
    // public List<Questions> findQuestionsByCompany(@Param("id") Long id);

    // public List<Questions> getQuestionsByCompanyCid(@Param("id") Long id);

}

// @Query("from Answer as a where a.questions.qaid =:id")
// public List<Answer> findAnswerByQuestions(@Param("id") Long id);