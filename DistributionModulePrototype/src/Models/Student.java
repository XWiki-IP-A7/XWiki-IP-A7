package Models;

public class Student {
    private String nr_matricol;
    private String name;
    private Teacher coordinator;

    public Student(String nr_matricol, String name) {
        this.nr_matricol = nr_matricol;
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public String getNr_matricol() {
        return nr_matricol;
    }

    public Student setCoordinator(Teacher coordinator) {
        this.coordinator = coordinator;
        coordinator.addStudent(this);
        return this;
    }

    public Teacher getCoordinator() {
        return coordinator;
    }

    @Override
    public String toString() {
        return name;
    }
}
