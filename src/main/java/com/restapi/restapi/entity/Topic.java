package com.restapi.restapi.entity;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Topic {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long tid;

    private String topicname;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "topic")
    @JsonIgnore
    private List<SubTopic> subtopic = new ArrayList<>();

    public Topic() {
    }

    public Long getTid() {
        return tid;
    }

    public void setTid(Long tid) {
        this.tid = tid;
    }

    public String getTopicname() {
        return topicname;
    }

    public void setTopicname(String topicname) {
        this.topicname = topicname;
    }

    public List<SubTopic> getSubtopic() {
        return subtopic;
    }

    public void setSubtopic(List<SubTopic> subtopic) {
        this.subtopic = subtopic;
    }

    //////////
}
