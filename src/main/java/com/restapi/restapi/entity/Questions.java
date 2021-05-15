package com.restapi.restapi.entity;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Questions {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long qaid;

    private String questiontext;

    private Long companyid;

    private Long subtopicid;

    @ManyToMany
    @JsonIgnore
    private List<Company> company = new ArrayList<>();

    @ManyToMany

    private List<SubTopic> subtopic = new ArrayList<>();

    @ManyToOne
    @JsonIgnore
    private User user;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "questions")
    @JsonIgnore
    private List<Answer> answer = new ArrayList<>();

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "questions")
    @JsonIgnore

    private List<Question_like> question_likes = new ArrayList<>();

    public Questions() {
    }

    public Long getQaid() {
        return qaid;
    }

    public void setQaid(Long qaid) {
        this.qaid = qaid;
    }

    public String getQuestiontext() {
        return questiontext;
    }

    public void setQuestiontext(String questiontext) {
        this.questiontext = questiontext;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public List<Answer> getAnswer() {
        return answer;
    }

    public void setAnswer(List<Answer> answer) {
        this.answer = answer;
    }

    public List<Question_like> getQuestion_likes() {
        return question_likes;
    }

    public void setQuestion_likes(List<Question_like> question_likes) {
        this.question_likes = question_likes;
    }

    public List<Company> getCompany() {
        return company;
    }

    public void setCompany(List<Company> company) {
        this.company = company;
    }

    public List<SubTopic> getSubtopic() {
        return subtopic;
    }

    public void setSubtopic(List<SubTopic> subtopic) {
        this.subtopic = subtopic;
    }

    public Long getCompanyid() {
        return companyid;
    }

    public void setCompanyid(Long companyid) {
        this.companyid = companyid;
    }

    public Long getSubtopicid() {
        return subtopicid;
    }

    public void setSubtopicid(Long subtopicid) {
        this.subtopicid = subtopicid;
    }

}
