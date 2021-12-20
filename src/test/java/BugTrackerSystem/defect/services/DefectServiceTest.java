package BugTrackerSystem.defect.services;

import BugTrackerSystem.defect.models.Defect;
import BugTrackerSystem.defect.repos.DefectRepo;
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
    private Defect defect;





}
