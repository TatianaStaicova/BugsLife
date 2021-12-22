package BugTrackerSystem.defect.controllers;


import BugTrackerSystem.BaseControllerTest;
import BugTrackerSystem.defect.models.Defect;
import BugTrackerSystem.defect.services.DefectService;
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
import org.hamcrest.core.Is;


import static org.hamcrest.core.Is.is;
import static org.mockito.ArgumentMatchers.any;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;


@SpringBootTest
@AutoConfigureMockMvc
@ExtendWith(SpringExtension.class)
public class DefectControllerTest extends BaseControllerTest {

    @MockBean
    private DefectService mockDefectService;

    @Autowired
    private MockMvc mockMvc;
    private Defect emptyDefect;
    private Defect mockDefect;

    @BeforeEach
    public void setUp() {
        emptyDefect = new Defect();
        emptyDefect.setId(1);
        mockDefect = new Defect("needed", "high", "also high", "Project01", "the awesome description", "this very environmentType");
        mockDefect.setId(2);
    }

    @Test
    @DisplayName("Post Test")
    public void createDefectTest() throws Exception {
        BDDMockito.doReturn(mockDefect).when(mockDefectService).createDefect(any());

        mockMvc.perform(MockMvcRequestBuilders.post("/defects")
                .contentType(MediaType.APPLICATION_JSON)
                .content(asJsonString(mockDefect)))
                .andExpect(MockMvcResultMatchers.status().isCreated())
                .andExpect(MockMvcResultMatchers.content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.jsonPath("$.id",Is.is(2)))
                .andExpect(MockMvcResultMatchers.jsonPath("$.projectName", Is.is("Project 01")));
    }




}
