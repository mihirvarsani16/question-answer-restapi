package com.restapi.restapi.controller;

import java.util.List;
import java.util.Optional;

import com.restapi.restapi.entity.Answer;
import com.restapi.restapi.entity.Answer_like;
import com.restapi.restapi.entity.Comment;
import com.restapi.restapi.entity.Question_like;
import com.restapi.restapi.entity.Questions;
import com.restapi.restapi.entity.User;
import com.restapi.restapi.services.UserServices;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserServices userServices;

    @PostMapping("/adduser")
    public ResponseEntity<User> addUser(@RequestBody User user) {
        User u = null;

        try {

            u = userServices.addUser(user);

            return ResponseEntity.of(Optional.of(u));

        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }

    }

    // add question

    @PostMapping("/addquestion/{id}")
    public ResponseEntity<Questions> addQuestions(@RequestBody Questions questions, @PathVariable Long id) {

        Questions q = null;

        try {
            System.out.println(questions.getQaid());
            q = this.userServices.addQuestion(questions, id);
            return ResponseEntity.of(Optional.of(q));

        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }

    }

    /// delete question

    @DeleteMapping("/delete/{id}")
    public void deleteQuestion(@PathVariable Long id) {

        this.userServices.deleteQuestions(id);

    }

    // get question by company

    @GetMapping("/getquestion/{id}")
    public ResponseEntity<List<Questions>> getQuestion(@PathVariable Long id) {

        List<Questions> q = this.userServices.getquetion(id);

        if (q.size() <= 0) {

            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();

        }

        return ResponseEntity.status(HttpStatus.CREATED).body(q);

    }

    // answer the question by user

    @PostMapping("/ans/{id}")
    public ResponseEntity<Answer> givAnswer(@RequestBody Answer answer, @PathVariable Long id) {

        Answer a = null;

        try {

            a = this.userServices.giveAnswer(answer, id);

            return ResponseEntity.of(Optional.of(a));

        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }

    }

    // get ans by question

    @GetMapping("getans/{id}")
    public ResponseEntity<List<Answer>> getAnswer(@PathVariable Long id) {

        List<Answer> a = this.userServices.getAnswer(id);

        if (a.size() <= 0) {

            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }

        return ResponseEntity.status(HttpStatus.CREATED).body(a);

    }

    /// for comment user

    @PostMapping("/comment/{id}")
    public ResponseEntity<Comment> getComment(@RequestBody Comment comment, @PathVariable Long id) {

        Comment c = null;

        try {
            c = this.userServices.giveComment(comment, id);
            return ResponseEntity.of(Optional.of(c));
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }

    }

    // get comment by ans

    @GetMapping("getcomment/{id}")
    public ResponseEntity<List<Comment>> getComment(@PathVariable Long id) {

        List<Comment> c = this.userServices.getComment(id);

        if (c.size() <= 0) {

            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }

        return ResponseEntity.status(HttpStatus.CREATED).body(c);

    }

    /// for q-like by user

    @PostMapping("/q-like/{id}")
    public ResponseEntity<Question_like> getComment(@RequestBody Question_like question_like, @PathVariable Long id) {

        Question_like q = null;

        try {
            q = this.userServices.giveLike(question_like, id);
            return ResponseEntity.of(Optional.of(q));
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }

    }

    /// no of like a question
    @GetMapping("nooflike/{id}")
    public ResponseEntity<List<Question_like>> noOFLike(@PathVariable Long id) {

        List<Question_like> ql = this.userServices.noOfLike(id);

        if (ql.size() <= 0) {

            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }

        return ResponseEntity.status(HttpStatus.CREATED).body(ql);

    }

    // ans like user

    @PostMapping("/ans-like/{id}")
    public ResponseEntity<Answer_like> ansLike(@RequestBody Answer_like answer_like, @PathVariable Long id) {

        Answer_like a = null;

        try {
            a = this.userServices.ansLike(answer_like, id);
            return ResponseEntity.of(Optional.of(a));
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }

    }

    ///// mo of ans like

    @GetMapping("noofanslike/{id}")
    public ResponseEntity<List<Answer_like>> noOFAnsLike(@PathVariable Long id) {

        List<Answer_like> u = this.userServices.noOfAnsLike(id);

        if (u.size() <= 0) {

            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }

        return ResponseEntity.status(HttpStatus.CREATED).body(u);

    }

    // get user

    @GetMapping("/getuser/{id}")
    public ResponseEntity<User> getUser(@PathVariable Long id) {

        User u = this.userServices.gerUser(id);

        if (u == null) {

            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }

        return ResponseEntity.status(HttpStatus.CREATED).body(u);

    }

    /////////////////////////////////////
}
