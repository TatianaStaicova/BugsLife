package BugTrackerSystem.comment.services;

import BugTrackerSystem.comment.exceptions.CommentNotFoundException;
import BugTrackerSystem.comment.models.Comment;

public interface CommentService {

    Comment createComment(Comment comment);
    Comment changeComment(int id, Comment comment) throws CommentNotFoundException;
    boolean deleteComment(int id) throws CommentNotFoundException;
    Comment getCommentById(int id) throws CommentNotFoundException;

}
