package internal;

import role.Evaluation;

import java.util.Date;

/**
 * @author Victor Manoliu on 05-May-18
 */

/**
 * Implementation of the Evaluation component
 */

public class Dissertation implements Evaluation {

    private Date firstDay;
    private Date secondDay;

    @Override
    public void setEvaluationDay(Date firstDay, Date secondDay) {
        this.firstDay = firstDay;
        this.secondDay = secondDay;
    }

    @Override
    public boolean checkEvaluation() {
        if (firstDay.compareTo(secondDay) <= 0)
            return false;
        return true;
    }

    public Date getFirstDay() {
        return firstDay;
    }

    public Date getSecondDay() {
        return secondDay;
    }

    public void setFirstDay(Date firstDay) {
        this.firstDay = firstDay;
    }

    public void setSecondDay(Date secondDay) {
        this.secondDay = secondDay;
    }


}
