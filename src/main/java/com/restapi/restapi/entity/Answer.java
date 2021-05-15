package com.restapi.restapi.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Answer {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long aid;

    private String answer;

    @ManyToOne
    @JsonIgnore
    private Questions questions;

    @ManyToOne
    @JsonIgnore
    private User user;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "answer")
    private List<Answer_like> answer_likes = new ArrayList<>();

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "answer")
    private List<Comment> comment = new ArrayList<>();

    public Answer() {
    }

    public Long getAid() {
        return aid;
    }

    public void setAid(Long aid) {
        this.aid = aid;
    }

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }

    public Questions getQuestions() {
        return questions;
    }

    public void setQuestions(Questions questions) {
        this.questions = questions;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public List<Answer_like> getAnswer_likes() {
        return answer_likes;
    }

    public void setAnswer_likes(List<Answer_like> answer_likes) {
        this.answer_likes = answer_likes;
    }

    public List<Comment> getComment() {
        return comment;
    }

    public void setComment(List<Comment> comment) {
        this.comment = comment;
    }

}
