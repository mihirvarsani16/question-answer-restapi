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

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class SubTopic {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long sid;

    private String subtopicname;

    @ManyToOne
    @JsonIgnore
    private Topic topic;

    @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "subtopic")
    @JsonIgnore
    private List<Questions> questions = new ArrayList<>();

    public SubTopic() {
    }

    public Long getSid() {
        return sid;
    }

    public void setSid(Long sid) {
        this.sid = sid;
    }

    public String getSubtopicname() {
        return subtopicname;
    }

    public void setSubtopicname(String subtopicname) {
        this.subtopicname = subtopicname;
    }

    public Topic getTopic() {
        return topic;
    }

    public void setTopic(Topic topic) {
        this.topic = topic;
    }

    public List<Questions> getQuestions() {
        return questions;
    }

    public void setQuestions(List<Questions> questions) {
        this.questions = questions;
    }

}
