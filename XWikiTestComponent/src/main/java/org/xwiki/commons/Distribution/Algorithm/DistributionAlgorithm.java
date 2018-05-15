package org.xwiki.commons.Distribution.Algorithm;


import org.xwiki.commons.Distribution.Models.*;

import java.util.List;

public interface DistributionAlgorithm {
    void partitionTeachers(List<Teacher> teachers, List<Committee> committees, List<Constraint> constraints);
}
