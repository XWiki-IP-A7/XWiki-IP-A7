package Constraints;

import Models.Repartition;

public interface Constraint
{
    /**
     *
     * @param repartition - the repartition to test the constraint on
     * @return true if the constraint is met
     */
    boolean test(Repartition repartition);

    /**
     *
     * @return true if the constraint is "hard" and has to be met no matter what, false otherwise
     */
    boolean isHard();
}
