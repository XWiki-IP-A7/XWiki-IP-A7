package Algorithm;

import Models.*;

import java.util.ArrayList;
import java.util.List;

public class DegreeDistributionAlgorithm implements DistributionAlgorithm {
    public List<Repartition> getRepatitions(List<Student> students,List<Teacher> teachers, List<Committee> committees) {
        List<Repartition> repartitions = new ArrayList<>();

        final int avgStudentsPerCommitte = students.size() / committees.size();

        for (Teacher teacher : teachers) {
            if (teacher.getCommittee() != null)
                for (Student student : teacher.getStudents()) {
                    repartitions.add(new Repartition(student, teacher.getCommittee()));
                }
        }

        Committee chosenCommittee = null;
        for (Teacher teacher : teachers) {
            if (teacher.getCommittee() == null) {
                int minDifference = avgStudentsPerCommitte;
                for (Committee committee : committees) {
                    if (minDifference > Math.abs(committee.getNumberOfStudents() - avgStudentsPerCommitte)) {
                        minDifference = Math.abs(committee.getNumberOfStudents() - avgStudentsPerCommitte);
                        chosenCommittee = committee;
                    }
                }
                chosenCommittee.setAuxiliaryTeacher(teacher);

                for (Student student : teacher.getStudents()) {
                    repartitions.add(new Repartition(student, teacher.getCommittee()));
                }
            }
        }
        return repartitions;
    }
}
