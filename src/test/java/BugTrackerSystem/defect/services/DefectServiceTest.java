package BugTrackerSystem.defect.services;

import BugTrackerSystem.defect.models.Defect;
import BugTrackerSystem.defect.repos.DefectRepo;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@SpringBootTest
@ExtendWith(SpringExtension.class)
public class DefectServiceTest {

    @MockBean
    private DefectRepo mockDefectRepo;

    @Autowired
    private DefectService defectService;
    private Defect emptyDefect;
    private Defect mockDefect;

    @BeforeEach
    public void setUp(){
        emptyDefect = new Defect();
        mockDefect = new Defect("needed", "high", "also high", "Project01", "the awesome description", "this very environmentType");
    /*    new Defect(),
                new Defect("Made up", "Made up","Made up"),
                new Defect("opened", "low", "also low", "Project22", "the awesome test description", "it's giving office"));*/

    }

    @Test
    @DisplayName("Creation")
    public void createDefectTest(){

    }



}
