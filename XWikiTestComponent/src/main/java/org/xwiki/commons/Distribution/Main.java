package org.xwiki.commons.Distribution;

import org.xwiki.commons.Distribution.Algorithm.DegreeDistributionAlgorithm;
import org.xwiki.commons.Distribution.Algorithm.DistributionAlgorithm;
import org.xwiki.commons.Distribution.Models.*;


import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Main {

    public static String algoritmCall()
    {
        final int noOfStudents = 247;
        final int noOfTeachers = 41;
        final int noOfCommittees = 6;
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
                committees.get(i % noOfCommittees).addCommitteeTeacher(teachers.get(i));
            }
        } catch (IndexOutOfBoundsException exception) {
            System.out.println("Invalid input: number of committees multiplied by " +
                    "the number of teachers per committee must be less than the total number of teachers");
        }

        //Adding students along with their coordinator
        List<Student> students = new ArrayList<>();

        Random random = new Random();

        int teacher_no;
        for (int i = 0; i < noOfStudents; i++) {
            teacher_no = random.nextInt(noOfTeachers);
            students.add(new Student(String.format("%d", i), "stud" + i).setCoordinator(teachers.get(teacher_no)));
        }

        //Adding constraints
        List<Constraint> constraints = new ArrayList<>();
        for (Teacher teacher : teachers) {
            if (teacher.getCommittee() == null)
                if (random.nextDouble() > 0.5) {
                    int committee_no = random.nextInt(noOfCommittees);
                    constraints.add(new Constraint(teacher, committees.get(committee_no)));
                }
        }

        DistributionAlgorithm distributionAlgorithm = new DegreeDistributionAlgorithm();
        distributionAlgorithm.partitionTeachers(teachers, committees, constraints);

        StringBuilder stringBuilder = new StringBuilder();

        for (Committee committee : committees) {
            stringBuilder.append(committee);
        }

        return stringBuilder.toString();
    }

    public static void main(String[] args) {
        System.out.println(algoritmCall());
    }
}
