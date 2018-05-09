package Algorithm;

import Models.*;
import javafx.util.Pair;

import java.util.ArrayList;
import java.util.List;

public class DegreeDistributionAlgorithm implements DistributionAlgorithm {
    public List<Repartition> getRepatitions(List<Student> students, List<Committee> committees) {
        List<Repartition> repartitions = new ArrayList<>();
        for (Student student : students) {
            if (student.getCoordinator().getCommittee() != null)
                repartitions.add(new Repartition(student, student.getCoordinator().getCommittee()));
        }
        return repartitions;
    }
}
