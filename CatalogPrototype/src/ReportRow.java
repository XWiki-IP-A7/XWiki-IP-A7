public class ReportRow {

    private Student student;

    public ReportRow(Student student) {
        this.student = student;
    }

    public Student getStudent() {
        return student;
    }

    public double calculateAverage(Task task) {
        int total = 0, num = 0;
        for (Grade g : student.getNote()) {
            if (g.getTask() == task) {
                total += g.getValoare();
                num++;
            }
        }
        return (double)total / (double)num;
    }

    public double calculateAverage() {
        return (calculateAverage(Task.TASK1) + calculateAverage(Task.TASK2)) / 2.0;
    }
}
