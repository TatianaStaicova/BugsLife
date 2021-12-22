package BugTrackerSystem.defect.repos;

import BugTrackerSystem.defect.models.Defect;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;


public interface DefectRepo extends JpaRepository<Defect, Integer> {


    Optional<Defect> findById(Integer id);
    Optional<Defect> findByProjectName(String projectName);

}
