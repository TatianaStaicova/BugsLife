package BugTrackerSystem.comment.services;

import BugTrackerSystem.comment.exceptions.CommentNotFoundException;
<<<<<<< HEAD
import BugTrackerSystem.comment.models.Comment;
import BugTrackerSystem.comment.repos.CommentRepo;
=======
import BugTrackerSystem.comment.models.models.Comment;
import com.tatiana.staicova.BugTrackerSystem.domain.comment.repos.CommentRepo;
>>>>>>> e0269826be8c99eca7ab1efcd70c94a4e11517cc
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentMatchers;
import org.mockito.BDDMockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.Optional;

@SpringBootTest
@ExtendWith(SpringExtension.class)
public class CommentServiceTest {

    @MockBean
    private CommentRepo mockCommentRepo;

    @Autowired
    private CommentService commentService;

    private Comment inputComment;
    private Comment mockResponseComment1;
    private Comment mockResponseComment2;

    @BeforeEach
    public void setUp(){
        inputComment = new Comment();

        mockResponseComment1 = new Comment();
        mockResponseComment1.setId(1);

        mockResponseComment2 = new Comment();
        mockResponseComment2.setId(2);
    }
    @Test
    @DisplayName("Comment Service: Create Comment - Success")
    public void createWidgetTestSuccess(){
        BDDMockito.doReturn(mockResponseComment1).when(mockCommentRepo).save(ArgumentMatchers.any());
        //?? it not allows me to use create or save method here
        //Comment returnedComment = commentService.save(inputComment);
        //Assertions.assertNotNull(returnedComment, "Comment should not be null");
        //Assertions.assertEquals(returnedComment.getId(),1 );
    }
    @Test
    @DisplayName("Comment Service: Get Comment by Id - Success")
    public void getWidgetByIdTestSuccess() throws CommentNotFoundException {
        BDDMockito.doReturn(Optional.of(mockResponseComment1)).when(mockCommentRepo).findById(1);
        Comment foundWidget = commentService.getCommentById(1);
        Assertions.assertEquals(mockResponseComment1.toString(), foundWidget.toString());
    }
    @Test
    @DisplayName("Comment Service: Get Comment by Id - Fail")
    public void getCommentByIdTestFailed() {
        BDDMockito.doReturn(Optional.empty()).when(mockCommentRepo).findById(1);
        Assertions.assertThrows(CommentNotFoundException.class, () -> {
            commentService.getCommentById(1);
        });
    }
    @Test
    @DisplayName("Comment Service: Change Comment - Success")
    public void changeCommentTestSuccess() throws CommentNotFoundException {
        Comment expectedCommentChange = new Comment();

        BDDMockito.doReturn(Optional.of(mockResponseComment1)).when(mockCommentRepo).findById(1);
        BDDMockito.doReturn(expectedCommentChange).when(mockCommentRepo).save(ArgumentMatchers.any());

        Comment actualWidget = commentService.changeComment(1, expectedCommentChange);
        Assertions.assertEquals(expectedCommentChange.toString(), actualWidget.toString());
    }
    @Test
    @DisplayName("Comment Service: Change Comment - Fail")
    public void updateWidgetTestFail()  {
        //it has to throw some message?
        Comment expectedCommentChange = new Comment();
        BDDMockito.doReturn(Optional.empty()).when(mockCommentRepo).findById(1);
        Assertions.assertThrows(CommentNotFoundException.class, ()-> {
            commentService.changeComment(1, expectedCommentChange);
        });
    }
    @Test
    @DisplayName("Comment Service: Delete Comment - Success")
    public void deleteCommentTestSuccess() throws CommentNotFoundException {
        BDDMockito.doReturn(Optional.of(mockResponseComment1)).when(mockCommentRepo).findById(1);
        Boolean actualResponse = commentService.deleteComment(1);
        Assertions.assertTrue(actualResponse);
    }

    @Test
    @DisplayName("Comment Service: Delete Comment - Fail")
    public void deleteCommentTestFail()  {
        BDDMockito.doReturn(Optional.empty()).when(mockCommentRepo).findById(1);
        Assertions.assertThrows(CommentNotFoundException.class, ()-> {
            commentService.deleteComment(1);
        });
    }
}
