package internal;

import entity.Degree;
import role.Evaluation;

import java.util.Date;
import java.util.HashMap;

/**
 * @author Victor Manoliu on 05-May-18
 */

/**
 * Implementation of the Evaluation component
 */

public class Bachelor implements Evaluation {

    private Date firstDay;
    private Date lastDay;

    @Override
    public void setEvaluationDay(Date firstDay, Date secondDay) {
        this.firstDay = firstDay;
        this.lastDay = secondDay;
    }

    @Override
    public boolean checkEvaluation() {
        if (firstDay.compareTo(lastDay) <= 0)
            return false;
        return true;
    }

    public Date getFirstDay() {
        return firstDay;
    }

    public Date getLastDay() {
        return lastDay;
    }

    public void setFirstDay(Date firstDay) {
        this.firstDay = firstDay;
    }

    public void setLastDay(Date lastDay) {
        this.lastDay = lastDay;
    }
}
