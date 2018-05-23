package Algorithm;

import Models.*;

import java.util.List;

public interface DistributionAlgorithm {
    void partitionTeachers(List<Teacher> teachers, List<Committee> committees, List<Constraint> constraints);
    boolean checkAnomalies(List<Committee> committees);
    List<StudentRepartition> getRepartitions(List<GenericScheduler<Committee>> committeeRepartitions);
}
