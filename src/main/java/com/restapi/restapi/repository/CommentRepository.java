package com.restapi.restapi.repository;

import java.util.List;

import com.restapi.restapi.entity.Comment;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface CommentRepository extends JpaRepository<Comment, Long> {

    @Query("from Comment as c where c.answer.aid =:id")
    public List<Comment> findCommentByAnswer(@Param("id") Long id);

}
