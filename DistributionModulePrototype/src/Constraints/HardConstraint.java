package Constraints;

import Models.Repartition;
import Models.Teacher;

import java.util.function.Predicate;

public final class HardConstraint implements Constraint
{
    private Teacher teacher;
    private Predicate predicate;

    /**
     *
     * @param predicate the constraint to test, might be a challenge to get it into a predicate form, needs more research first
     * @param target not used yet, might not be useful at all, needs more thinking
     */
    HardConstraint(Predicate<Repartition> predicate, Teacher target)
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
        return true;
    }
}
