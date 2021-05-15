package com.restapi.restapi.controller;

import java.util.List;
import java.util.Optional;

import com.restapi.restapi.entity.Company;
import com.restapi.restapi.entity.SubTopic;
import com.restapi.restapi.entity.Topic;
import com.restapi.restapi.services.UserServices;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/question")
public class BasicController {

    @Autowired
    private UserServices userServices;

    @PostMapping("/company")
    public ResponseEntity<Company> createCompany(@RequestBody Company company) {

        Company c = null;

        try {
            c = userServices.createCompany(company);
            System.out.println(company);
            return ResponseEntity.of(Optional.of(c));
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }

    }

    // get company

    @GetMapping("/allcompany")
    public ResponseEntity<List<Company>> getAllCompany() {

        List<Company> list = userServices.getAllCompany();
        if (list.size() <= 0) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        return ResponseEntity.status(HttpStatus.CREATED).body(list);

    }

    // get company by id

    @GetMapping("/getcompany/{id}")
    public ResponseEntity<Company> getCompany(@PathVariable Long id) {

        Company c = this.userServices.getCompany(id);

        if (c == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        return ResponseEntity.status(HttpStatus.CREATED).body(c);

    }

    /// add topic
    @PostMapping("/addtopic")
    public ResponseEntity<Topic> addTopic(@RequestBody Topic topic) {

        Topic t = null;

        try {
            t = userServices.addTopic(topic);
            return ResponseEntity.of(Optional.of(t));
        } catch (Exception e) {

            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();

        }

    }

    // get topic

    @GetMapping("/gettopic")
    public ResponseEntity<List<Topic>> getAllTopic() {

        List<Topic> topics = this.userServices.getAllTopic();

        if (topics.size() <= 0) {

            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }

        return ResponseEntity.status(HttpStatus.CREATED).body(topics);

    }

    // add sutopic

    @PostMapping("/addsubtopic/{id}")
    public ResponseEntity<SubTopic> addSubTopic(@RequestBody SubTopic subTopic, @PathVariable("id") Long id) {

        SubTopic a = null;

        try {

            a = this.userServices.addSubtopic(subTopic, id);

            return ResponseEntity.of(Optional.of(a));
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }

    }

    // get sub topic by topic
    @GetMapping("/getsubtopic/{id}")
    public ResponseEntity<List<SubTopic>> getSubtopic(@PathVariable Long id) {

        List<SubTopic> t = this.userServices.getSubtopic(id);

        if (t.size() <= 0) {

            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        return ResponseEntity.status(HttpStatus.CREATED).body(t);

    }

    //////////
}
