package BugTrackerSystem.defect.models;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;


public class DefectTest {


    @Autowired
    private Defect emptyDefect;
    private Defect mockDefect;

    @BeforeEach
    public void setUp(){
        emptyDefect = new Defect();
        mockDefect = new Defect("needed", "high", "also high", "Project01", "the awesome description", "this very environmentType");
    }





}
