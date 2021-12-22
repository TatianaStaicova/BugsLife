package BugTrackerSystem.defect.services;

import BugTrackerSystem.defect.exceptions.DefectNotFoundException;
import BugTrackerSystem.defect.models.Defect;
import BugTrackerSystem.defect.repos.DefectRepo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DefectServiceImp implements DefectService{

    private static final Logger logger = LoggerFactory.getLogger(DefectServiceImp.class);
    private DefectRepo defectRepo;

    @Autowired
    public DefectServiceImp(DefectRepo repo){
        this.defectRepo = repo;
    }

    @Override
    public Defect createDefect(Defect defect) {
        Defect savedDefect = defectRepo.save(defect);
        return savedDefect;
    }

    @Override
    public Defect getDefectById(Integer id) throws DefectNotFoundException {
        return null;
    }

    @Override
    public List<Defect> getAllDefects() {
        return null;
    }

    @Override
    public Defect updateWidget(Integer id, Defect defect) throws DefectNotFoundException {
        return null;
    }

    @Override
    public Boolean deleteDefect(Integer id) throws DefectNotFoundException {
        return null;
    }
}
