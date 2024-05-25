package com.sparta.springtask1.repository;

import com.sparta.springtask1.entity.Comment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CommentRepository extends JpaRepository<Comment, Long> {

}
