package role;

import java.util.Date;

/**
 * @author Victor Manoliu on 05-May-18
 */

/**
 * The other role of our module aka it will have the @Component annotation
 */

public class SignUp {

    private Date firstDay;
    private Date lastDay;

    public SignUp(Date firstDay, Date lastDay)
    {
        this.firstDay = firstDay;
        this.lastDay = lastDay;
    }

    public void setFirstDay(Date firstDay) {
        this.firstDay = firstDay;
    }

    public void setLastDay(Date lastDay) {
        this.lastDay = lastDay;
    }

    public Date getFirstDay() {
        return firstDay;
    }

    public Date getLastDay() {
        return lastDay;
    }
}
