package Models;

public class Schedule implements Comparable {
    private int day;
    private int startTime;
    private int endTime;
    private int assignedTime;

    public Schedule(Integer day, Integer startTime, Integer endTime) {
        this.day = day;
        this.startTime = startTime;
        if (endTime == null)
            this.endTime = 20 * 60;
        else this.endTime = endTime;
        assignedTime = 0;
    }

    public Integer getDay() {
        return day;
    }

    public Integer getStartTime() {
        return startTime;
    }

    public Integer getEndTime() {
        return endTime;
    }

    public int getDuration() {
        return endTime - startTime;
    }

    public void addAssignedTime(int duration) {
        assignedTime += duration;
    }

    public int getAssignedTime() {
        return assignedTime;
    }

    public int getTimeLeft() {
        return getDuration() - assignedTime;
    }

    @Override
    public int compareTo(Object o) {
        Schedule schedule = (Schedule) o;
        if (this.day < schedule.day)
            return -1;
        if (this.day == schedule.day)
            if (this.startTime < schedule.startTime)
                return -1;
            else if (this.startTime == schedule.startTime)
                return 0;
            else return 1;
        else return 1;
    }

    public String toHour(int minutes) {
        return ((minutes / 60) / 10 % 10) + "" + ((minutes / 60) % 10) + ":" + ((minutes / 10) % 6) + (minutes % 10);
    }

    public String toDay(int day) {
        switch (day) {
            case 0: return "Luni";
            case 1: return "Marti";
            case 2: return "Miercuri";
            case 3: return "Joi";
            case 4: return "Vineri";
            case 5: return "Sambata";
            case 6: return "Duminica";
            default: return null;
        }
    }

    @Override
    public String toString() {
        return toDay(day) + ": " + toHour(startTime) + " --> " + toHour(endTime);
    }
}
