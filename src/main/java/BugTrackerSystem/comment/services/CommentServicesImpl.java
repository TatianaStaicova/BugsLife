package BugTrackerSystem.comment.services;

import BugTrackerSystem.comment.exceptions.CommentNotFoundException;
import BugTrackerSystem.comment.models.models.Comment;
import com.tatiana.staicova.BugTrackerSystem.domain.comment.repos.CommentRepo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CommentServicesImpl implements CommentService {
    private static Logger logger = LoggerFactory.getLogger(CommentServicesImpl.class);

    private CommentRepo commentRepo;

    @Autowired
    public CommentServicesImpl(CommentRepo commentRepo){
        this.commentRepo = commentRepo;
    }

    @Override
    public Comment createComment(Comment comment) {
        return commentRepo.save(comment);
    }

    @Override
    public Comment changeComment(int id, Comment comment) throws CommentNotFoundException {
        Optional<Comment> commentFound = commentRepo.findById(id);
        if(commentFound.isEmpty()){
            throw new CommentNotFoundException("Comment does not exists, can not change");
        }
        Comment savedComment = commentFound.get();
        savedComment.setName(comment.getName());
        savedComment.setCommentBody(comment.getCommentBody());
        return commentRepo.save(savedComment);
    }

    @Override
    public boolean deleteComment(int id) throws CommentNotFoundException {
        Optional<Comment> commentOptional = commentRepo.findById(id);
        if(commentOptional.isEmpty()){
            throw new CommentNotFoundException("Comment does not exist, can not delete");
        }
        Comment commentToDelete = commentOptional.get();
        commentRepo.delete(commentToDelete);
        return true;
    }

    @Override
    public Comment getCommentById(int id) throws CommentNotFoundException {
        Optional<Comment> commentOptional = commentRepo.findById(id);
        if(commentOptional.isEmpty()){
            logger.error("Comment with id {} does not exist", id);
            throw new CommentNotFoundException("Comment not found");
        }
        return commentOptional.get();
    }

}
