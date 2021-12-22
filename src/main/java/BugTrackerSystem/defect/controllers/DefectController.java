package BugTrackerSystem.defect.controllers;

import BugTrackerSystem.defect.exceptions.DefectNotFoundException;
import BugTrackerSystem.defect.models.Defect;
import BugTrackerSystem.defect.services.DefectService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/defects")
public class DefectController {

    private static Logger logger = LoggerFactory.getLogger(DefectController.class);
    private DefectService defectService;

    @Autowired
    public DefectController(DefectService defectService){
        this.defectService = defectService;
    }

    @PostMapping("")
    public ResponseEntity<Defect> showAll(@RequestBody Defect defect){
        Defect savedDefect = defectService.createDefect(defect);
      return new ResponseEntity(savedDefect, HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getDefectById(@PathVariable Integer id){
        try {
            Defect defect = defectService.getDefectById(id);
            ResponseEntity<?> response = new ResponseEntity<>(defect, HttpStatus.OK);
            return response;
        } catch (DefectNotFoundException e) {
            return ResponseEntity
                    .status(HttpStatus.NOT_FOUND)
                    .build();
        }
    }


}
