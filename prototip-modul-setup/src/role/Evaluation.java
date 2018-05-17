package role;

import java.util.Date;

/**
 * @author Victor Manoliu on 05-May-18
 */

/**
 * One of the roles of our module aka it will have the @Component annotation
 */

public interface Evaluation {

    Date firstDay = null;
    Date secondDay = null;

    void setEvaluationDay(Date firstDay, Date secondDay);

    public boolean checkEvaluation();
}
