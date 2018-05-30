import Algorithm.DegreeDistributionAlgorithm;
import Algorithm.DistributionAlgorithm;
import Models.*;

import java.util.*;

public class Main {
    public static void distributeTeachers(List<Teacher> teachers, List<Committee> committees, List<Constraint> constraints) {
        DistributionAlgorithm distributionAlgorithm = new DegreeDistributionAlgorithm();
        distributionAlgorithm.partitionTeachers(teachers, committees, constraints);

        while (distributionAlgorithm.checkAnomalies(committees)) {
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
        List<StudentRepartition> studentRepartitions = degreeDistributionAlgorithm.getRepartitions(committeeRepartitions);

        for (StudentRepartition studentReaprtition : studentRepartitions) {
            Committee committee = studentReaprtition.getStudent().getCoordinator().getCommittee();
            System.out.println("Student: " + studentReaprtition.getStudent().getName() +
                    "   Programat: " + studentReaprtition.getSchedule() +
                    "   Comisia: " + committee.toString(studentReaprtition.getStudent()));
        }
    }

    public static void main(String[] args) {
        List<Teacher> teachers = new ArrayList<>();
        List<Committee> committees = new ArrayList<>();
        List<Constraint> constraints = new ArrayList<>();
        generateData(teachers, committees, constraints);
        distributeTeachers(teachers, committees, constraints);
        repartitionStudents(committees);
    }

    private static Committee getFullestCommittee(List<Committee> committees) {
        int maxStudents = Integer.MIN_VALUE;
        Committee fullestCommittee = null;
        if (committees != null)
            for (Committee committee : committees) {
                if (committee.hasConstraintMembers()) {
                    int noOfStudents = committee.getNumberOfStudents();
                    if (maxStudents < noOfStudents) {
                        maxStudents = noOfStudents;
                        fullestCommittee = committee;
                    }
                }
            }
        return fullestCommittee;
    }

    private static void generateData(List<Teacher> teachers, List<Committee> committees, List<Constraint> constraints) {
        final int noOfStudents = 247;
        final int noOfTeachers = 41;
        final int noOfCommittees = 6;
        final double teachersPerCommittee = 4;
// merge git
        //Adding teachers
        for (int i = 0; i < noOfTeachers; i++) {
            teachers.add(new Teacher(i, "prof" + i));
        }

        //Adding committees
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
            students.add(new Student(String.valueOf(i), "stud" + i).setCoordinator(teachers.get(teacher_no)));
        }

        for (Teacher teacher : teachers) {
            if (teacher.getStudents() == null) {
                students.get(random.nextInt(noOfStudents)).setCoordinator(teacher);
            }

        }

        //Adding constraints
        for (Teacher teacher : teachers) {
            if (teacher.getCommittee() == null)
                if (random.nextDouble() > 0.5) {
                    int committee_no = random.nextInt(noOfCommittees);
                    constraints.add(new Constraint(teacher, committees.get(committee_no)));
                }
        }
    }
}
