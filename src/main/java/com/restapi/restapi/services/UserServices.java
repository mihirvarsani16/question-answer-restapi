package com.restapi.restapi.services;

import java.util.List;

import com.restapi.restapi.entity.Answer;
import com.restapi.restapi.entity.Answer_like;
import com.restapi.restapi.entity.Comment;
import com.restapi.restapi.entity.Company;
import com.restapi.restapi.entity.Question_like;
import com.restapi.restapi.entity.Questions;
import com.restapi.restapi.entity.SubTopic;
import com.restapi.restapi.entity.Topic;
import com.restapi.restapi.entity.User;

public interface UserServices {

    // add company
    public Company createCompany(Company company);

    // get company

    public List<Company> getAllCompany();

    // get company by id

    public Company getCompany(Long id);

    // topic add

    public Topic addTopic(Topic topic);

    // get topic

    public List<Topic> getAllTopic();

    // add sub topic

    public SubTopic addSubtopic(SubTopic subTopic, Long id);

    // get topic with sub topic

    public List<SubTopic> getSubtopic(Long id);

    // user add

    public User addUser(User user);

    // add question

    public Questions addQuestion(Questions questions, Long id);

    // delete

    public void deleteQuestions(Long id);

    // get question by company

    public List<Questions> getquetion(Long id);

    // add ans

    public Answer giveAnswer(Answer answer, Long id);

    // get ans by question

    public List<Answer> getAnswer(Long id);

    // for comment by user

    public Comment giveComment(Comment comment, Long id);

    // det comment by answer

    public List<Comment> getComment(Long id);

    // add like question

    public Question_like giveLike(Question_like question_like, Long id);

    // no of like a question

    public List<Question_like> noOfLike(Long id);

    // add like ans

    public Answer_like ansLike(Answer_like answer_like, Long id);

    // no of ans like

    public List<Answer_like> noOfAnsLike(Long id);

    // user

    public User gerUser(Long id);

}
