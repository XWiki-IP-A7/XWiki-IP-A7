package Algorithm;

import Models.*;

import java.util.ArrayList;
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
        for (Constraint constraint:constraints) {
            constraint.getCommittee().addConstraintTeacher(constraint.getTeacher());
        }
    }

    private int getNoOfStudents(List<Teacher> teachers) {
        int noOfStudents = 0;
        if (teachers != null)
        for (Teacher teacher:teachers) {
            if (teacher.getStudents() != null)
                noOfStudents += teacher.getStudents().size();
        }
        return noOfStudents;
    }
}
