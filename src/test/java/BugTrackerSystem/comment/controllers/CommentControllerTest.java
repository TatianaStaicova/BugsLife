package BugTrackerSystem.comment.controllers;

import BugTrackerSystem.BaseControllerTest;
import BugTrackerSystem.comment.exceptions.CommentNotFoundException;
import BugTrackerSystem.comment.models.Comment;
import BugTrackerSystem.comment.repos.CommentRepo;
import BugTrackerSystem.comment.services.CommentService;
import org.hamcrest.core.Is;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.BDDMockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import static java.lang.reflect.Array.get;
import static net.bytebuddy.matcher.ElementMatchers.is;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.client.match.MockRestRequestMatchers.content;
import static org.springframework.test.web.client.match.MockRestRequestMatchers.jsonPath;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
@ExtendWith(SpringExtension.class)
public class CommentControllerTest extends BaseControllerTest {

    @MockBean
    private CommentRepo mockCommentRepo;

    @MockBean
    private CommentService commentService;

    @Autowired
    private MockMvc mockMvc;

    private Comment inputComment;
    private Comment mockResponseComment1;
    private Comment mockResponseComment2;

    @BeforeEach
    public void setUp(){
        inputComment = new Comment();
        inputComment.setId(1);
        inputComment.setCommentBody("comment");

        mockResponseComment1 = new Comment();
        mockResponseComment1.setId(1);
//        mockResponseComment1.setName("Test Comment 01");
        mockResponseComment1.setCommentBody("comment");

        mockResponseComment2 = new Comment();
        mockResponseComment2.setId(2);

    }

    @Test
    @DisplayName("Comment Post: /comments - success")
    public void createCommentRequestSuccess() throws Exception {
        when(commentService.createComment(inputComment)).thenReturn(mockResponseComment1);

        mockMvc.perform(post("/comments/createComment")
                        .content(asJsonString(inputComment))
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isCreated())
                .andReturn();
    }

    @Test
    @DisplayName("GET /comments/1 - Found")
    public void getCommentByIdTestSuccess() throws Exception{
        when(commentService.getCommentById(1)).thenReturn(mockResponseComment1);

        mockMvc.perform(MockMvcRequestBuilders.get("/comments/{id}", 1)
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andReturn();


    }
    @Test
    @DisplayName("GET /comments/1 - Not Found")
    public void getCommentByIdTestFail() throws Exception {
        doThrow(new CommentNotFoundException("Not Found")).when(commentService).getCommentById(anyInt());
        mockMvc.perform(MockMvcRequestBuilders.get("/comments/{id}", anyInt()))
                .andExpect(status().isNotFound());
    }

    @Test
    @DisplayName("PUT /comments/1 - Success")
    public void changeComment() throws Exception{

        Comment expectedCommentChange = new Comment();
        expectedCommentChange.setCommentBody("Changed Comment");

        when(commentService.changeComment(1, inputComment)).thenReturn(expectedCommentChange);

        mockMvc.perform(put("/comments/{id}", 1)
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(asJsonString(inputComment)))
                .andExpect(status().isOk());
    }

    @Test
    @DisplayName("PUT /comments/1 - Not Found")
    public void deleteComment() throws Exception{
        doReturn(true).when(commentService).deleteComment(anyInt());

        mockMvc.perform(put("/comments/{id}", 1)
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isNoContent());
    }
}
