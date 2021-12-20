package BugTrackerSystem.defect.services;

import BugTrackerSystem.defect.exceptions.DefectNotFoundException;
import BugTrackerSystem.defect.models.Defect;

import java.util.List;

public interface DefectService {
//CRUD
        Defect createDefect(Defect defect);
        Defect getDefectById(Long id) throws DefectNotFoundException;
        List<Defect> getAllDefects();
        Defect updateWidget(Long id, Defect defect ) throws DefectNotFoundException;
        Boolean deleteDefect(Long id) throws DefectNotFoundException;


        //List<Defect> getAllDefectsByProjectName();

}
