package BugTrackerSystem.defect.models;

public class Defect {

    private Long id;
    private String status;
    private String priority;
    private String severity;
    private String projectName;
    private String developerName;
    private String description;
    private String environmentType;
    private String resolutionDesc;

    public Defect(){

    }

    public Defect(String status, String priority, String severity, String projectName, String description, String environmentType) {
        this.status = status;
        this.priority = priority;
        this.severity = severity;
        this.projectName = projectName;
        this.description = description;
        this.environmentType = environmentType;
    }

    public Long getId() {

        return id;
    }

    public void setId(Long id) {

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
