package Algorithm;

import Models.Committee;
import Models.Repartition;
import Models.Student;
import Models.Teacher;
import javafx.util.Pair;

import java.util.List;

public interface DistributionAlgorithm {
    List<Repartition> getRepatitions(List<Student> students, List<Committee> committees);
}
