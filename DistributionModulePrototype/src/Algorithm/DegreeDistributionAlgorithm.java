package Algorithm;

import Models.*;

import java.util.*;

public class DegreeDistributionAlgorithm implements DistributionAlgorithm {
    public void partitionTeachers(List<Teacher> teachers, List<Committee> committees, List<Constraint> constraints) {
        final int avgStudentsPerCommittee = getNoOfStudents(teachers) / committees.size();
        setConstraints(constraints);
        Committee chosenCommittee = null;
        for (Teacher teacher : teachers) {
            if (teacher.getCommittee() == null) {
                int minDifference = avgStudentsPerCommittee;
                for (Committee committee : committees) {
                    int noOfStudentsInCommittee = committee.getNumberOfStudents();
                    if (minDifference > noOfStudentsInCommittee - avgStudentsPerCommittee) {
                        minDifference = noOfStudentsInCommittee - avgStudentsPerCommittee;
                        chosenCommittee = committee;
                    }
                }

                assert chosenCommittee != null;
                chosenCommittee.addAuxiliaryTeacher(teacher);
            }
        }
    }

    private void setConstraints(List<Constraint> constraints) {
        if (constraints != null)
            for (Constraint constraint : constraints) {
                constraint.getCommittee().addConstraintTeacher(constraint.getTeacher());
            }
    }

    private int getNoOfStudents(List<Teacher> teachers) {
        int noOfStudents = 0;
        if (teachers != null)
            for (Teacher teacher : teachers) {
                if (teacher.getStudents() != null)
                    noOfStudents += teacher.getStudents().size();
            }
        return noOfStudents;
    }

    public boolean checkAnomalies(List<Committee> committees) {
        int maxStudents = Integer.MIN_VALUE;
        int minStudents = Integer.MAX_VALUE;
        int totalStudents = 0;
        int noOfStudents;
        if (committees != null) {
            for (Committee committee : committees) {
                if (committee != null) {
                    noOfStudents = committee.getNumberOfStudents();
                    if (maxStudents < noOfStudents)
                        maxStudents = noOfStudents;
                    if (minStudents > noOfStudents)
                        minStudents = noOfStudents;
                    totalStudents += noOfStudents;
                }
            }
        }
        System.out.println("Total studs: " + totalStudents + "\nMax diff: " + (maxStudents - minStudents));
        System.out.println("Percentage: " + (maxStudents - minStudents) * 100 / totalStudents + "%");

        return (maxStudents - minStudents) * 100 / totalStudents > 5;
    }

    public List<StudentRepartition> getRepartitions(List<GenericScheduler<Committee>> committeeRepartitions) {
        List<GenericScheduler<Teacher>> teacherRepartitions = new ArrayList<>();
        for (GenericScheduler<Committee> committeeRepartition : committeeRepartitions) {
            teacherRepartitions.addAll(getTeacherRepartitions(committeeRepartition));
        }

        List<StudentRepartition>studentRepartitions = new ArrayList<>();
        for (GenericScheduler<Teacher> teacherRepartition : teacherRepartitions) {
            Iterator<Schedule> iterator = teacherRepartition.getSchedules().iterator();
            Schedule schedule = iterator.next();
            for (Student student:teacherRepartition.getEntity().getStudents()) {
                while (true) {
                    if (schedule.getTimeLeft() >= 20) {
                        int start = schedule.getStartTime() + schedule.getAssignedTime();
                        Schedule studentSchedule = new Schedule(schedule.getDay(), start, start + 20);
                        schedule.addAssignedTime(20);
                        studentRepartitions.add(new StudentRepartition(student, studentSchedule));
                        break;
                    }
                    else if (iterator.hasNext())
                        schedule = iterator.next();
                }
            }
        }

        Collections.sort(studentRepartitions, Comparator.comparing(e -> e.getSchedule()));
        return studentRepartitions;
    }

    private List<GenericScheduler<Teacher>> getTeacherRepartitions(GenericScheduler<Committee> committeeRepartition) {
        List<Teacher> teachers = committeeRepartition.getEntity().getAuxiliaryMembers();
        boolean repartitionFound = false;
        List<GenericScheduler<Teacher>> teacherRepartitions = new ArrayList<>();
        int timeNeeded;

        for (Teacher teacher : teachers) {
            timeNeeded = teacher.getNumberOfStudents() * 20;
            List<Schedule> schedules = new ArrayList<>();
            for (Schedule schedule : committeeRepartition.getSchedules()) {
                if (schedule.getTimeLeft() > timeNeeded) {
                    int start = schedule.getStartTime() + schedule.getAssignedTime();
                    Schedule memberSchedule = new Schedule(schedule.getDay(), start, start + timeNeeded);
                    schedule.addAssignedTime(timeNeeded);
                    schedules.add(memberSchedule);
                    repartitionFound = true;
                    teacherRepartitions.add(new GenericScheduler<>(teacher, schedules));
                    break;
                }
            }
        }

        teachers = committeeRepartition.getEntity().getMembers();
        for (Teacher teacher : teachers) {
            timeNeeded = teacher.getNumberOfStudents() * 20;
            List<Schedule> schedules = new ArrayList<>();
            while (timeNeeded > 0) {
                for (Schedule schedule : committeeRepartition.getSchedules()) {
                    int availableTime = (schedule.getTimeLeft() / 20) * 20;
                    if (timeNeeded < availableTime)
                        availableTime = timeNeeded;
                    timeNeeded -= availableTime;

                    int start = schedule.getStartTime() + schedule.getAssignedTime();
                    Schedule memberSchedule = new Schedule(schedule.getDay(), start, start + availableTime);
                    schedule.addAssignedTime(availableTime);
                    schedules.add(memberSchedule);
                    repartitionFound = true;
                    if (timeNeeded == 0) {
                        break;
                    }

                }
                teacherRepartitions.add(new GenericScheduler<>(teacher, schedules));
            }
        }
        return teacherRepartitions;
    }
}
