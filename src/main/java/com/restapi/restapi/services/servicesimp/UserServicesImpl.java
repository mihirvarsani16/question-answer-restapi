package com.restapi.restapi.services.servicesimp;

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
import com.restapi.restapi.repository.AnswerRepository;
import com.restapi.restapi.repository.Answer_likeRepository;
import com.restapi.restapi.repository.CommentRepository;
import com.restapi.restapi.repository.CompanyRepository;
import com.restapi.restapi.repository.QuestionRepository;
import com.restapi.restapi.repository.Question_likeRepository;
import com.restapi.restapi.repository.SubTopicRepository;
import com.restapi.restapi.repository.TopicRepository;
import com.restapi.restapi.repository.UserRepository;
import com.restapi.restapi.services.UserServices;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServicesImpl implements UserServices {

    @Autowired
    private CompanyRepository companyRepository;

    @Autowired
    private TopicRepository topicRepository;

    @Autowired
    private SubTopicRepository subTopicRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private QuestionRepository questionRepository;

    @Autowired
    private AnswerRepository answerRepository;

    @Autowired
    private CommentRepository commentRepository;

    @Autowired
    private Question_likeRepository question_likeRepository;

    @Autowired
    private Answer_likeRepository answer_likeRepository;

    @Override
    public Company createCompany(Company company) {

        return this.companyRepository.save(company);
    }

    // get company
    @Override
    public List<Company> getAllCompany() {

        return this.companyRepository.findAll();
    }

    // get company by id
    @Override
    public Company getCompany(Long id) {

        return this.companyRepository.findByCid(id);
    }

    // add topic
    @Override
    public Topic addTopic(Topic topic) {

        return this.topicRepository.save(topic);
    }

    // get all topic
    @Override
    public List<Topic> getAllTopic() {

        return this.topicRepository.findAll();
    }

    // add sub topic

    @Override
    public SubTopic addSubtopic(SubTopic subTopic, Long id) {
        Topic topic = this.topicRepository.findTopicBytid(id);

        subTopic.setTopic(topic);

        topic.getSubtopic().add(subTopic);

        SubTopic s = this.subTopicRepository.save(subTopic);
        this.topicRepository.save(topic);

        return s;
    }

    // get topic with sub topic

    @Override
    public List<SubTopic> getSubtopic(Long id) {
        List<SubTopic> subTopics = this.subTopicRepository.findSubTopicByTopic(id);
        return subTopics;
    }

    // add user
    @Override
    public User addUser(User user) {

        return this.userRepository.save(user);
    }

    // add question

    @Override
    public Questions addQuestion(Questions questions, Long id) {

        User user = this.userRepository.findUserByuid(id);

        questions.setUser(user);

        user.getQuestions().add(questions);
        // this.userRepository.save(user);

        /*
         * User user = this.userRepository.findUserByuid(id);
         * 
         * questions.setUser(user);
         * 
         * user.getQuestions().add(questions);
         * 
         * this.userRepository.save(user);
         * 
         */
        // company

        Long c = questions.getCompanyid();
        Company company = this.companyRepository.findByCid(c);
        questions.getCompany().add(company);
        // company.getQuestions().add(questions);
        // this.companyRepository.save(company);

        // subtopic

        SubTopic subTopic = this.subTopicRepository.findBySid(questions.getSubtopicid());
        questions.getSubtopic().add(subTopic);
        // subTopic.getQuestions().add(questions);
        // this.subTopicRepository.save(subTopic);

        return this.questionRepository.save(questions);
    }

    // delete question
    @Override
    public void deleteQuestions(Long id) {

        this.questionRepository.deleteById(id);
    }

    // get question by company

    @Override
    public List<Questions> getquetion(Long id) {

        // return this.questionRepository.findAllById(id);
        return this.questionRepository.findQuestionsBycompanyid(id);
        // return this.questionRepository.findQuestionsByCompany(id);
        // return this.questionRepository.getQuestionsByCompanyCid(id);
    }

    // give ans

    @Override
    public Answer giveAnswer(Answer answer, Long id) {

        // User user = this.userRepository.findUserByuid(id);

        // answer.setUser(user);

        // Questions questions =
        // this.questionRepository.findQuestionsByqaid(answer.getQid());
        // answer.setQuestions(questions);

        return this.answerRepository.save(answer);
    }

    // get ans throw question

    @Override
    public List<Answer> getAnswer(Long id) {

        return this.answerRepository.findAnswerByQuestions(id);
    }

    // give comment user
    @Override
    public Comment giveComment(Comment comment, Long id) {

        User user = this.userRepository.findUserByuid(id);
        if (user == null) {

            try {
                throw new Exception("User not predent");
            } catch (Exception e) {

                e.printStackTrace();
            }

        } else {

            comment.setUser(user);
            Answer answer = this.answerRepository.findAnswerByaid(comment.getAid());
            comment.setAnswer(answer);

            comment = this.commentRepository.save(comment);
        }

        return comment;
    }

    // get comment throw ans
    @Override
    public List<Comment> getComment(Long id) {

        return this.commentRepository.findCommentByAnswer(id);
    }

    // like question
    @Override
    public Question_like giveLike(Question_like question_like, Long id) {

        User user = this.userRepository.findUserByuid(id);
        if (user == null) {

            try {
                throw new Exception("User not predent");
            } catch (Exception e) {

                e.printStackTrace();
            }

        } else {

            question_like.setUser(user);

            Questions questions = this.questionRepository.findQuestionsByqaid(question_like.getQid());
            question_like.setQuestions(questions);

            question_like = this.question_likeRepository.save(question_like);

        }

        return question_like;
    }

    // no of like a question

    @Override
    public List<Question_like> noOfLike(Long id) {

        return this.question_likeRepository.findQuestion_likesByQuestions(id);
    }

    // ans like

    @Override
    public Answer_like ansLike(Answer_like answer_like, Long id) {
        User user = this.userRepository.findUserByuid(id);
        if (user == null) {

            try {
                throw new Exception("User not predent");
            } catch (Exception e) {

                e.printStackTrace();
            }

        } else {

            answer_like.setUser(user);

            Answer answer = this.answerRepository.findAnswerByaid(answer_like.getAid());
            if (answer == null) {
                try {
                    throw new Exception("answer not predent");
                } catch (Exception e) {

                    e.printStackTrace();
                }
            } else {
                answer_like.setAnswer(answer);
                answer_like = this.answer_likeRepository.save(answer_like);

            }

        }

        return answer_like;
    }

    // no of ans like

    @Override
    public List<Answer_like> noOfAnsLike(Long id) {

        return this.answer_likeRepository.findAnswer_likeByAnswer(id);
    }

    // get user
    @Override
    public User gerUser(Long id) {

        return this.userRepository.findUserByuid(id);
    }

}
