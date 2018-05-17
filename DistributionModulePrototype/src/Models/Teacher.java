package Models;

import java.util.ArrayList;
import java.util.List;

public class Teacher {
    private int id;
    private String name;
    private Committee committee;
    private List<Student> students;

    public Teacher(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public int getId() {
        return id;
    }

    public void setCommittee(Committee committee) {
        this.committee = committee;
    }

    public Committee getCommittee() {
        return committee;
    }

    public List<Student> getStudents() {
        return students;
    }

    public void addStudent(Student student) {
        if (students == null)
            students = new ArrayList<>();
        students.add(student);
    }

    @Override
    public String toString() {
        return name;
    }
}
