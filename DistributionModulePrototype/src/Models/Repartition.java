package Models;

public class Repartition {
    private int hour;
    private Student student;
    private Committee committee;

    public Repartition(Student student, Committee committee) {
        this.student = student;
        this.committee = committee;
    }

    @Override
    public String toString() {
        return student + " -> " + committee;
    }
}
