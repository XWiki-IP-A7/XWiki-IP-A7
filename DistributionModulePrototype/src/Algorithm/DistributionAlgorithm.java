package Algorithm;

import Models.Committee;
import Models.Constraint;
import Models.Teacher;

import java.util.List;

public interface DistributionAlgorithm {
    void partitionTeachers(List<Teacher> teachers, List<Committee> committees, List<Constraint> constraints);
    boolean checkAnomalies(List<Committee> committees);
}
