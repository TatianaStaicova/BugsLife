package BugTrackerSystem.defect.services;

import BugTrackerSystem.defect.exceptions.DefectNotFoundException;
import BugTrackerSystem.defect.models.Defect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.List;


public interface DefectService {
//CRUD

        Defect createDefect(Defect defect);
        Defect getDefectById(Integer id) throws DefectNotFoundException;
        List<Defect> getAllDefects();
        Defect updateWidget(Integer id, Defect defect ) throws DefectNotFoundException;
        Boolean deleteDefect(Integer id) throws DefectNotFoundException;


        //List<Defect> getAllDefectsByProjectName();

}
