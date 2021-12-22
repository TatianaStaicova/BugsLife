package BugTrackerSystem.defect.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Defect {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    private String status;
    private String priority;
    private String severity;
    private String projectName;
    private String developerName;
    private String description;
    private String environmentType;
    private String resolutionDesc;

    public Defect(){
        this.description = "No description created";
        this.projectName = "No Project name created";
    }

    public Defect(String priority, String projectName, String description){
        this.priority = priority;
        this.projectName = projectName;
        this.description = description;
    }


    public Defect(String status, String priority, String severity, String projectName, String description, String environmentType) {
        this.status = status;
        this.priority = priority;
        this.severity = severity;
        this.projectName = projectName;
        this.description = description;
        this.environmentType = environmentType;
    }

    public Integer getId() {

        return id;
    }

    public void setId(Integer id) {

        this.id = id;
    }

    public String getStatus() {

        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getPriority() {
        return priority;
    }

    public void setPriority(String priority) {
        this.priority = priority;
    }

    public String getSeverity() {
        return severity;
    }

    public void setSeverity(String severity) {
        this.severity = severity;
    }

    public String getProjectName() {
        return projectName;
    }

    public void setProjectName(String projectName) {
        this.projectName = projectName;
    }

    public String getDeveloperName() {
        return developerName;
    }

    public void setDeveloperName(String developerName) {
        this.developerName = developerName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getEnvironmentType() {
        return environmentType;
    }

    public void setEnvironmentType(String environmentType) {
        this.environmentType = environmentType;
    }

    public String getResolutionDesc() {
        return resolutionDesc;
    }

    public void setResolutionDesc(String resolutionDesc) {
        this.resolutionDesc = resolutionDesc;
    }

    @Override
    public String toString() {
        return "Defect{" +
                "id=" + id +
                ", status='" + status + '\'' +
                ", priority='" + priority + '\'' +
                ", severity='" + severity + '\'' +
                ", projectName='" + projectName + '\'' +
                ", developerName='" + developerName + '\'' +
                ", description='" + description + '\'' +
                ", environmentType='" + environmentType + '\'' +
                ", resolutionDesc='" + resolutionDesc + '\'' +
                '}';
    }
}
