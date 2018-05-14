package registration.model;

import java.util.List;

public class Candidate extends Student {

    private Teacher coordinator;

    private Project project;

    private List<Course> courses;

    public Candidate(String firstName, String lastName, String studentID, Teacher coordinator, Project project, List<Course> courses) {
        super(firstName, lastName, studentID);
        this.coordinator = coordinator;
        this.project = project;
        this.courses = courses;
    }

    public Teacher getCoordinator() {
        return coordinator;
    }

    public void setCoordinator(Teacher coordinator) {
        this.coordinator = coordinator;
    }

    public Project getProject() {
        return project;
    }

    public void setProject(Project project) {
        this.project = project;
    }

    public List<Course> getCourses() {
        return courses;
    }

    public void setCourses(List<Course> courses) {
        this.courses = courses;
    }

    @Override
    public String toString() {
        return "Candidate{" +
                "coordinator=" + coordinator +
                ", project=" + project +
                ", courses=" + courses +
                '}';
    }
}