public class Main {
    public static void main(String[] args) {
        Student student1 = new Student("10000", "Gafitescu", "Marian");
        /*Student student2 = new Student("10001", "Iurescu", "Alexandru");
        Student student3 = new Student("10002", "Pomohaci", "Alexandru");
        Student student4 = new Student("10009", "Sfirnaciuc", "Emilia");
        Student student5 = new Student("10004", "Martincu", "Petru");
        Student student6 = new Student("10005", "Gritco", "Sorin");
        Student student7 = new Student("10006", "Sergiu", "Ghimp");
        Student student8 = new Student("10007", "Covaliu", "Lucian");
        Student student9 = new Student("10008", "Tapuc", "Andrada");*/


        Profesor profesor1 = new Profesor();
        Profesor profesor2 = new Profesor();
        Profesor profesor3 = new Profesor();

        profesor1.setGrade(new Grade(Task.Task_1, student1, 10));
        profesor2.setGrade(new Grade(Task.Task_1, student1, 9));
        profesor3.setGrade(new Grade(Task.Task_1, student1, 8));

        profesor1.setGrade(new Grade(Task.Task_2, student1, 8));
        profesor2.setGrade(new Grade(Task.Task_2, student1, 9));
        profesor3.setGrade(new Grade(Task.Task_2, student1, 6));

        ReportRow reportRow1 = new ReportRow(student1);

        System.out.println(reportRow1.calculateAverage());
}

}
