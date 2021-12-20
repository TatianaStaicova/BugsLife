package BugTrackerSystem.defect.services;

import BugTrackerSystem.defect.exceptions.DefectNotFoundException;
import BugTrackerSystem.defect.models.Defect;
import BugTrackerSystem.defect.repos.DefectRepo;
import org.springframework.beans.factory.annotation.Autowired;
import java.util.List;

public class DefectServiceImp implements DefectService{

    private DefectRepo defectRepo;

    @Autowired
    public DefectServiceImp(DefectRepo repo){
        this.defectRepo = repo;
    }

    @Override
    public Defect createDefect(Defect defect) {
        Defect savedDefect = defectRepo.save(defect);
        return null;
    }

    @Override
    public Defect getDefectById(Long id) throws DefectNotFoundException {
        return null;
    }

    @Override
    public List<Defect> getAllDefects() {
        return null;
    }

    @Override
    public Defect updateWidget(Long id, Defect defect) throws DefectNotFoundException {
        return null;
    }

    @Override
    public Boolean deleteDefect(Long id) throws DefectNotFoundException {
        return null;
    }
}
