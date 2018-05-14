package registration.internal;

import org.xwiki.component.annotation.Component;
import registration.InputHandler;
import registration.model.*;

import javax.inject.Singleton;
import java.util.ArrayList;
import java.util.List;

@Component
@Singleton
public class DefaultInputHandler implements InputHandler {

    @Override
    public Candidate execute() {
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
        System.out.println("returning new candidate");
        return candidate;
    }
}
