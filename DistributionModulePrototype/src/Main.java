import Algorithm.DegreeDistributionAlgorithm;
import Models.*;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        final int noOfStudents = 30;
        final int noOfTeachers = 10;
        final int noOfCommittees = 2;
        final double teachersPerCommittee = 4;

        //Adding teachers
        List<Teacher> teachers = new ArrayList<>();
        for (int i = 0; i < noOfTeachers; i++) {
            teachers.add(new Teacher(i, "prof" + i));
        }

        //Adding committees
        List<Committee> committees = new ArrayList<>();
        for (int i = 0; i < noOfCommittees; i++) {
            committees.add(new Committee());
        }

        //Adding teachers to committees
        try {
            for (int i = 0; i < noOfCommittees * teachersPerCommittee; i++) {
                committees.get(i % noOfCommittees).addTeacher(teachers.get(i));
            }
        } catch (IndexOutOfBoundsException exception) {
            System.out.println("Invalid input: number of committees multiplied by " +
                    "the number of teachers per committee must be less than the total number of teachers");
        }

        //Adding students along with their coordinator
        List<Student> students = new ArrayList<>();

        int teacher = 0;
        for (int i = 0; i < noOfStudents; i++) {
            students.add(new Student(String.format("%d", i), "stud" + i).setCoordinator(teachers.get(teacher)));
            teacher++;
            if (teacher == noOfTeachers)
                teacher = 0;
        }

        List<Repartition> repartitions = new DegreeDistributionAlgorithm().getRepatitions(students,teachers,committees);

        for (Repartition repartition:repartitions) {
            System.out.println(repartition);
        }
    }
}
