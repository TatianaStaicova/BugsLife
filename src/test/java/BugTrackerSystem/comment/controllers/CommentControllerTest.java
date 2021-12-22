package BugTrackerSystem.comment.controllers;

import BugTrackerSystem.comment.services.CommentService;
import com.tatiana.staicova.BugTrackerSystem.domain.comment.models.Comment;
import com.tatiana.staicova.BugTrackerSystem.domain.comment.repos.CommentRepo;
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
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import static java.lang.reflect.Array.get;
import static net.bytebuddy.matcher.ElementMatchers.is;
import static org.mockito.ArgumentMatchers.any;
import static org.springframework.test.web.client.match.MockRestRequestMatchers.content;
import static org.springframework.test.web.client.match.MockRestRequestMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
@ExtendWith(SpringExtension.class)
public class CommentControllerTest {

    @MockBean
    private CommentRepo mockCommentRepo;

    @Autowired
    private CommentService commentService;

    @Autowired
    private MockMvc mockMvc;

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
    @DisplayName("Comment Post: /comments - success")
    public void createCommentRequestSuccess() throws Exception {
        BDDMockito.doReturn(mockResponseComment1).when(commentService.createComment(inputComment));
//        BDDMockito.doReturn(any()).when(commentService).createComment(any());

        mockMvc.perform(MockMvcRequestBuilders.post("/comment")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isCreated())
                .andExpect(MockMvcResultMatchers.content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.jsonPath("$.id", Is.is(1)))
                .andExpect(MockMvcResultMatchers.jsonPath("$.name", Is.is("Test Comment 01")));
    }

//    @Test
//    @DisplayName("GET /comments/1 - Found")
//    public void getCommentByIdTestSuccess() throws Exception{
//        BDDMockito.doReturn(mockResponseComment1).when(mockCommentService).getCommentById(1);
//
//        mockMvc.perform(get("/comments/{id}", 1))
//                .andExpect(status().isOk())
//                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
//                .andExpect(jsonPath("$.id", is(1)))
//                .andExpect(jsonPath("$.name", is("Test Comment 01")));
//    }
//    @Test
//    @DisplayName("GET /comments/1 - Not Found")
//    public void getCommentByIdTestFail() throws Exception {
//        BDDMockito.doThrow(new CommentNotFoundException("Not Found")).when(mockCommentService).getCommentById(1);
//        mockMvc.perform(get("/comments/{id}", 1))
//                .andExpect(status().isNotFound());
//    }
//    @Test
//    @DisplayName("PUT /comments/1 - Success")
//    public void putCommentTestNotSuccess() throws Exception{
//
//        Comment expectedCommentChange = new Comment();
//        expectedCommentChange.setId(1);
//        BDDMockito.doReturn(expectedCommentChange).when(mockCommentService).commentChange(any(), any());
//        mockMvc.perform(put("/comments/{id}", 1)
//                        .contentType(MediaType.APPLICATION_JSON)
//                        .content(asJsonString(inputComment)))
//                .andExpect(status().isOk())
//                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
//                .andExpect(jsonPath("$.id", is(1)))
//                .andExpect(jsonPath("$.name", is("After Change Comment")));
//    }
//
//    @Test
//    @DisplayName("PUT /comments/1 - Not Found")
//    public void putCommentTestNotFound() throws Exception{
//        BDDMockito.doThrow(new CommentNotFoundException("Not Found")).when(mockCommentService).changeComment(any(), any());
//        mockMvc.perform(put("/comments/{id}", 1)
//                        .contentType(MediaType.APPLICATION_JSON)
//                        .content(asJsonString(inputComment)))
//                .andExpect(status().isNotFound());
//    }
}
