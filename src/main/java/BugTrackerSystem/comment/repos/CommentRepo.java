package com.tatiana.staicova.BugTrackerSystem.domain.comment.repos;

import com.tatiana.staicova.BugTrackerSystem.domain.comment.models.Comment;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CommentRepo extends JpaRepository<Comment, Integer> {
        Optional<Comment> findCommentById(Long id);
}
