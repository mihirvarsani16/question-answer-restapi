package com.restapi.restapi.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Question_like {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long qlid;

    @Column(nullable = false)
    private Long qid;

    @ManyToOne
    @JsonIgnore
    private Questions questions;

    @ManyToOne
    @JsonIgnore
    private User user;

    public Long getQlid() {
        return qlid;
    }

    public void setQlid(Long qlid) {
        this.qlid = qlid;
    }

    public Long getQid() {
        return qid;
    }

    public void setQid(Long qid) {
        this.qid = qid;
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

}
