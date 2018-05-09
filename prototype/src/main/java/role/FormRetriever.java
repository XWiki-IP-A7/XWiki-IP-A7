package role;

import model.*;
import org.apache.velocity.VelocityContext;

import java.util.ArrayList;
import java.util.List;

public class FormRetriever {

    private VelocityContext context;

    private Registration registration;

    public FormRetriever(Registration registration){
        this.registration=registration;
    }
    public void execute() {
        String firstName = "John";
        String lastName = "Doe";
        String studentId = "nr_matricol";
        Project project = new Project("model.Project title", "repo-link.link", "file-path/file.docx");
        Teacher teacher = new Teacher(TeachingDegree.Conf, "Johny Doe");
        List<Course> courses = new ArrayList<>();
        for (int i = 0; i < 3; i++) {
            courses.add(new Course("model.Course " +i));
        }
        Candidate candidate = new Candidate(firstName, lastName, studentId, teacher, project, courses);
        registration.addCandidate(candidate);
        System.out.println("adding new candidate");
    }

}