package BugTrackerSystem.defect.repos;

import BugTrackerSystem.defect.models.Defect;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface DefectRepo extends JpaRepository<Defect, Long> {


    Optional<Defect> findById();
    Optional<Defect> findByProjectName(String projectName);

}
