package BugTrackerSystem.comment.repos;

import BugTrackerSystem.comment.models.Comment;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CommentRepo extends JpaRepository<Comment, Integer> {
        Optional<Comment> findCommentById(Long id);
}
