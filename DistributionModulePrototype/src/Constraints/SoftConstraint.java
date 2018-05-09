package Constraints;

import Models.Repartition;
import Models.Teacher;

import java.util.function.Predicate;

public class SoftConstraint implements Constraint
{
    private Teacher teacher;
    private Predicate predicate;

    SoftConstraint(Predicate<Repartition> predicate, Teacher target)
    {
        teacher = target;
        this.predicate = predicate;
    }

    @Override
    public boolean test(Repartition repartition)
    {
        return predicate.test(repartition);
    }

    @Override
    public final boolean isHard()
    {
        return false;
    }
}
