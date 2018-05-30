package org.xwiki.distribution.Distribution.Algorithm;

import org.xwiki.distribution.Distribution.Models.*;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class AlgorithmCall {
    List<Teacher> teachers = new ArrayList<>();
    List<Committee> committees = new ArrayList<>();
    List<Student> students = new ArrayList<>();
    List<Constraint> constraints = new ArrayList<>();
    int noOfStudents = 247;
    int noOfTeachers = 41;
    int noOfCommittees = 6;
    int teachersPerCommittee = 4;

    public String sayHello() {
        return "General Kenobi!";
    }

    private static Committee getFullestCommittee(List<Committee> committees) {
        int maxStudents = Integer.MIN_VALUE;
        Committee fullestCommittee = null;
        if (committees != null)
            for (Committee committee : committees) {
                int noOfStudents = committee.getNumberOfStudents();
                if (maxStudents < noOfStudents) {
                    maxStudents = noOfStudents;
                    fullestCommittee = committee;
                }
            }
        return fullestCommittee;
    }

    public void setNoOfStudents(int noOfStudents) {
        this.noOfStudents = noOfStudents;
    }

    public void setTeachersPerCommittee(int teachersPerCommittee) {
        this.teachersPerCommittee = teachersPerCommittee;
    }

    public void setNoOfCommittees(int noOfCommittees) {
        this.noOfCommittees = noOfCommittees;
    }

    public void setNoOfTeachers(int noOfTeachers) {
        this.noOfTeachers = noOfTeachers;
    }

    public void addTeacher(int id, String name) {
        teachers.add(new Teacher(id, name));

    }

    private int findTeacherIndex(String name) {
        for (int i = 0; i < teachers.size(); i++)
            if (teachers.get(i).getName().equals(name))
                return i;
        return -1;
    }

    private Teacher findTeacher(String name) {
        for (int i = 0; i < teachers.size(); i++)
            if (teachers.get(i).getName().equals(name))
                return teachers.get(i);
        return null;
    }

    public void addCommittee(String id, String... args) {
        committees.add(new Committee(id));
        for (int i = 0; i < teachersPerCommittee; i++)
            committees.get(committees.size() - 1).addCommitteeTeacher(teachers.get(findTeacherIndex(args[i])));
    }

    private int findCommitteeIndex(String id)
    {
        for(int i=0; i< noOfCommittees;i++)
            if(committees.get(i).getId().equals(id))
                return i;
        return -1;
    }
    public void addConstraint(String teacherName, String committee)
    {
        Teacher teacher = findTeacher(teacherName);
        constraints.add(new Constraint(teacher, committees.get(findCommitteeIndex(committee))));
    }
    public void setStudents() {
        List<Student> students = new ArrayList<>();

        Random random = new Random();

        int teacher_no;
        for (int i = 0; i < noOfStudents; i++) {
            teacher_no = random.nextInt(noOfTeachers);
            students.add(new Student(String.format("%d", i), "stud" + i).setCoordinator(teachers.get(teacher_no)));
        }
    }

    public List<Student> getStudents (String teacherName)
    {
     Teacher teacher = findTeacher(teacherName);
     return teacher.getStudents();
    }

    public void addStudent(String studentName, String teacherName)
    {
        Teacher teacher = findTeacher(teacherName);
        Student student = new Student(studentName);
        student.setCoordinator(teacher);
        students.add(student);
    }

    public List<Committee> run() {
        DistributionAlgorithm distributionAlgorithm = new DegreeDistributionAlgorithm();
        distributionAlgorithm.partitionTeachers(teachers, committees, constraints);
        int noOfResets = 0;
        while (distributionAlgorithm.checkAnomalies(committees) && noOfResets < 10) {
            noOfResets++;
            Committee fullestCommittee = getFullestCommittee(committees);
            Teacher fullestTeacher = fullestCommittee.getFullestConstraintTeacher();
            for (Constraint constraint : constraints) {
                if (constraint.getTeacher() == fullestTeacher) {
                    constraints.remove(constraint);
                    break;
                }
            }

            for (Committee committee : committees) {
                committee.reset();
            }

            distributionAlgorithm.partitionTeachers(teachers, committees, constraints);

        }
        return committees;
    }

    public static void repartitionStudents(List<Committee> committees) {
        final int examinationDuration = 20;
        final int startHour = 8;
        final int endHour = 20;
        final int days = 7;
        List<GenericScheduler<Committee>> committeeRepartitions = new ArrayList<>();
        Random random = new Random();
        for (Committee committee : committees) {
            GenericScheduler<Committee> committeeRepartition = new GenericScheduler<>(committee, null);
            System.out.println(committee + " " + committee.getNumberOfStudents());
            int minDuration = committee.getFullestTeacher().getNumberOfStudents() * examinationDuration / 60;

            while (committeeRepartition.getDuration() < committee.getNumberOfStudents() * 20) {
                int day;
                do {
                    day = random.nextInt(days);
                } while (committeeRepartition.isBusy(day));
                int startsAt = random.nextInt(endHour - minDuration - startHour) + startHour;
                Integer endsAt = random.nextInt(endHour - startHour) + startHour;
                if (endsAt < startsAt + minDuration)
                    endsAt = endHour;
                Schedule schedule = new Schedule(day, startsAt * 60, endsAt * 60);
                committeeRepartition.addSchedule(schedule);
            }
            Collections.sort(committeeRepartition.getSchedules());
            committeeRepartitions.add(committeeRepartition);
        }
        DegreeDistributionAlgorithm degreeDistributionAlgorithm = new DegreeDistributionAlgorithm();
        List<StudentRepartition> studentRepartitions = degreeDistributionAlgorithm.getRepartitions(committeeRepartitions, null);

        for (StudentRepartition studentReaprtition : studentRepartitions) {
            Committee committee = studentReaprtition.getStudent().getCoordinator().getCommittee();
            System.out.println("Student: " + studentReaprtition.getStudent().getName() +
                    "   Programat: " + studentReaprtition.getSchedule() +
                    "   Comisia: " + committee.toString(studentReaprtition.getStudent()));
        }
    }


}
