package org.xwiki.distribution.Distribution.Algorithm;

import org.xwiki.distribution.Distribution.Models.Committee;
import org.xwiki.distribution.Distribution.Models.Constraint;
import org.xwiki.distribution.Distribution.Models.Teacher;

import java.util.List;

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
        if ((maxStudents - minStudents) * 100 / totalStudents > 5)
            return true;
        else return false;
    }
}
