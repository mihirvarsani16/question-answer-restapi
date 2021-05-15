package com.restapi.restapi.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Comment {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long cid;

    @Size(min = 50, max = 500)
    private String commentans;

    @ManyToOne
    @JsonIgnore

    private User user;

    @ManyToOne
    @JsonIgnore
    private Answer answer;

    @Column(nullable = false)
    private Long aid;

    public Comment() {
    }

    public Long getCid() {
        return cid;
    }

    public void setCid(Long cid) {
        this.cid = cid;
    }

    public String getCommentans() {
        return commentans;
    }

    public void setCommentans(String commentans) {
        this.commentans = commentans;
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
