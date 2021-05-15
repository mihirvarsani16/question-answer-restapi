package com.restapi.restapi.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Answer_like {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long alid;

    @ManyToOne
    @JsonIgnore
    private User user;

    @Column(nullable = false)
    private Long aid;

    @ManyToOne
    @JsonIgnore
    private Answer answer;

    public Answer_like() {
    }

    public Long getAlid() {
        return alid;
    }

    public void setAlid(Long alid) {
        this.alid = alid;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Answer getAnswer() {
        return answer;
    }

    public void setAnswer(Answer answer) {
        this.answer = answer;
    }

    public Long getAid() {
        return aid;
    }

    public void setAid(Long aid) {
        this.aid = aid;
    }

}
