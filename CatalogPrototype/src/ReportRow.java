public class ReportRow {

    private Student student;

    public ReportRow(Student student) {
        this.student = student;
    }

    public double calculateAverage() {
        return (this.student.getTotalProba1()/3.0 + this.student.getTotalProba2()/3.0)/2.0;
    }
}
