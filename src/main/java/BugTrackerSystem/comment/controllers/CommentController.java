package BugTrackerSystem.comment.controllers;

import BugTrackerSystem.comment.exceptions.CommentNotFoundException;
import com.tatiana.staicova.BugTrackerSystem.domain.comment.models.Comment;
import com.tatiana.staicova.BugTrackerSystem.domain.comment.repos.CommentRepo;
import com.tatiana.staicova.BugTrackerSystem.domain.comment.services.CommentService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/comments")
public class CommentController {

    private final Logger logger = LoggerFactory.getLogger(CommentController.class);
    private CommentService commentService;
    private CommentRepo commentRepo;

    @Autowired
    public CommentController(CommentService commentService) {
        this.commentService = commentService;
    }

    @PostMapping("/createComment")
    public ResponseEntity<Comment> createCommentRequest(@RequestBody Comment comment) {
        Comment createComment = commentService.createComment(comment);
        ResponseEntity<Comment> response = new ResponseEntity<>(createComment, HttpStatus.CREATED);
        return response;
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> changeComment(@PathVariable int id, @RequestBody Comment comment) {
        try {
            Comment changeComment = commentService.changeComment(id, comment);
            ResponseEntity<Comment> response = new ResponseEntity<>(changeComment, HttpStatus.OK);
            return response;
        } catch (CommentNotFoundException e) {
            return ResponseEntity
                    .status(HttpStatus.NOT_FOUND)
                    .build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteComment(@PathVariable Integer id) throws CommentNotFoundException {
        commentService.deleteComment(id);
        return ResponseEntity
                .status(HttpStatus.NO_CONTENT)
                .build();
    }


    @GetMapping("/{id}")
    public ResponseEntity<?> getCommentById(@PathVariable Integer id) {
        try {
            Comment comment = commentService.getCommentById(id);
            ResponseEntity<?> response = new ResponseEntity<>(comment, HttpStatus.OK);
            return response;
        } catch (CommentNotFoundException e) {
            return ResponseEntity
                    .status(HttpStatus.NOT_FOUND)
                    .build();
        }
    }

}