
public class Grade {
    private Task task;
    private Student student;
    private Profesor profesor;
    private int valoare;

    public Grade(Task task, Student student, Profesor profesor, int valoare) {
        this.task = task;
        this.student = student;
        this.profesor = profesor;
        this.valoare = valoare;
    }

    public Task getTask() {
        return task;
    }

    public Student getStudent() {
        return student;
    }

    public int getValoare() {
        return valoare;
    }
}
