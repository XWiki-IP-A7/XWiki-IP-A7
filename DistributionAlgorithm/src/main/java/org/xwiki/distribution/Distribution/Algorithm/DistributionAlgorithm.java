package org.xwiki.distribution.Distribution.Algorithm;


import org.xwiki.distribution.Distribution.Models.Committee;
import org.xwiki.distribution.Distribution.Models.Constraint;
import org.xwiki.distribution.Distribution.Models.Teacher;

import java.util.List;

public interface DistributionAlgorithm {
    void partitionTeachers(List<Teacher> teachers, List<Committee> committees, List<Constraint> constraints);
    boolean checkAnomalies(List<Committee> committees);
}
