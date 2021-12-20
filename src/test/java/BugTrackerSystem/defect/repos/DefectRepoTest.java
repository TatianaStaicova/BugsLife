package BugTrackerSystem.defect.repos;

import BugTrackerSystem.defect.models.Defect;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.junit.jupiter.api.Assertions;

import java.util.Arrays;
import java.util.List;

@ExtendWith(MockitoExtension.class)
@SpringBootTest
public class DefectRepoTest {

    @Autowired
    private DefectRepo defectTestRepo;

    @BeforeEach
    public void setUp(){
        List<Defect> defects = Arrays.asList(new Defect("created", "high", "also high", "Project01", "the awesome description", "this very environmentType"));

        defectTestRepo.saveAll(defects);
    }

    @AfterEach
    public void deleteEm(){
        defectTestRepo.deleteAll();
    }

    @Test
    @DisplayName("Saving defects")
    public void findEmAll(){
        List<Defect> defects = Arrays.asList(
                new Defect(),
                new Defect("Made up", "Made up","Made up"),
                new Defect("opened", "low", "also low", "Project22", "the awesome test description", "it's giving office"));

        defectTestRepo.saveAll(defects);


    }






}
