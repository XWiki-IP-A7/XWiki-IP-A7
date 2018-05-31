package org.xwiki.distribution.Distribution.Algorithm;

import org.xwiki.distribution.Distribution.Models.*;

import java.util.*;

public class AlgorithmCall {
    List<Teacher> teachers = new ArrayList<>();
    List<Committee> committees = new ArrayList<>();
    List<Student> students = new ArrayList<>();
    List<Constraint> constraints = new ArrayList<>();
    int noOfStudents = 247;
    int noOfTeachers = 41;
    int noOfCommittees = 6;
    int teachersPerCommittee = 4;
    Committee committee = new Committee();

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

    public Committee getCommitteeById(int id) {
        for (Committee committee : committees)
            if(committee.getId() == id)
                return committee;
        return new Committee();

    }

    public void addCommittee(int id, String... args) {
        committees.add(new Committee(id));
        for (int i = 0; i < teachersPerCommittee; i++)
            getCommitteeById(id).addCommitteeTeacher(teachers.get(findTeacherIndex(args[i])));
    }

    public  void addToCommittee(String name)
    {
        if(committee.getCommitteeCount()<4)
        committee.addCommitteeTeacher(teachers.get(findTeacherIndex(name)));
        else
            committee.addAuxiliaryTeacher(teachers.get(findTeacherIndex(name)));
    }

    private int findCommitteeIndex(int id)
    {
        for(int i=0; i< noOfCommittees;i++)
            if(committees.get(i).getId()==id)
                return i;
        return -1;
    }
    public void addConstraint(String teacherName, int committee)
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



    public List<StudentRepartition> repartitionStudents() {
        List<StudentRepartition> studentRepartitions = new ArrayList<>();
       try{
        committees.add(committee);
        final int examinationDuration = 20;
        final int startHour = 8;
        System.out.println("Intru in repartizare");
        final int endHour = 20;
        final int days = 7;
        List<GenericScheduler<Committee>> committeeRepartitions = new ArrayList<>();
        List<GenericScheduler<Committee>> committeeBreaks = new ArrayList<>();
        Random random = new Random();
        for (Committee committee : committees) {
            GenericScheduler<Committee> committeeRepartition = new GenericScheduler<>(committee, null);
            GenericScheduler<Committee> committeeBreak = new GenericScheduler<>(committee, null);
            System.out.println(committee);
            int minDuration = committee.getFullestTeacher().getNumberOfStudents() * examinationDuration / 60;
            int noOfBreaks = 1;
            while (committeeRepartition.getDuration() < committee.getNumberOfStudents() * 20 + 60 * noOfBreaks) {
                int day;
                do {
                    day = random.nextInt(days);
                } while (committeeRepartition.isBusy(day));
                int startsAt = random.nextInt(endHour - minDuration - startHour) + startHour;
                Integer endsAt = random.nextInt(endHour - startHour) + startHour;
                if (endsAt < startsAt + minDuration)
                    endsAt = endHour;
                Schedule schedule = new Schedule(day, startsAt * 60, endsAt * 60);
                Schedule generatedBreak = generateBreak(schedule);
                committeeBreak.addSchedule(generatedBreak);
                noOfBreaks++;
                committeeRepartition.addSchedule(schedule);
            }
            Collections.sort(committeeRepartition.getSchedules());
            committeeBreaks.add(committeeBreak);
            committeeRepartitions.add(committeeRepartition);
        }
        DegreeDistributionAlgorithm degreeDistributionAlgorithm = new DegreeDistributionAlgorithm();
        studentRepartitions = degreeDistributionAlgorithm.getRepartitions(committeeRepartitions, committeeBreaks);

        return studentRepartitions;
    }
    catch (Exception e)
    {
        System.out.println(e.getStackTrace());
    }
    finally {
           return studentRepartitions;
       }
    }

    public List<StudentRepartition> switchRepartitions(List<StudentRepartition> studentRepartitions, String studentName, int newPosition) {
        StudentRepartition givenStudentRepartition = null;
        if (studentRepartitions == null) {
            return null;
        }
        for (StudentRepartition studentRepartition : studentRepartitions) {
            if (studentRepartition.getStudent().getName().equals(studentName)) {
                givenStudentRepartition = studentRepartition;
                break;
            }
        }
        Schedule givenStudentSchedule = givenStudentRepartition.getSchedule();
        if (givenStudentRepartition != null) {
            studentRepartitions.remove(givenStudentRepartition);
            studentRepartitions.add(newPosition - 1, givenStudentRepartition);
        }
        Iterator<StudentRepartition> iterator = studentRepartitions.iterator();
        while (iterator.hasNext() && iterator.next() != givenStudentRepartition) {
        }
        StudentRepartition repartition1 = studentRepartitions.get(newPosition - 1);
        StudentRepartition repartition2 = null;
        while (iterator.hasNext()) {
            repartition2 = iterator.next();
            repartition1.setSchedule(repartition2.getSchedule());
            repartition1 = repartition2;
        }
        if (repartition2 != null)
            repartition2.setSchedule(givenStudentSchedule);
        return studentRepartitions;
    }

    private static Schedule generateBreak(Schedule schedule) {
        int start = (schedule.getStartTime() + schedule.getEndTime()) / 2;
        return new Schedule(schedule.getDay(), start, start + 60);
    }
}
