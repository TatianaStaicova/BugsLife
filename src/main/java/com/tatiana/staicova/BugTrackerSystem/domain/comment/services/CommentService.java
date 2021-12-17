package com.tatiana.staicova.BugTrackerSystem.domain.comment.services;

import com.tatiana.staicova.BugTrackerSystem.domain.comment.models.Comment;
import com.tatiana.staicova.BugTrackerSystem.exceptions.CommentNotFoundException;


public interface CommentService {

    Comment createComment(Comment comment);
    Comment changeComment(int id, Comment comment) throws CommentNotFoundException;
    boolean deleteComment(int id) throws CommentNotFoundException;
    Comment getCommentById(int id) throws CommentNotFoundException;

}
