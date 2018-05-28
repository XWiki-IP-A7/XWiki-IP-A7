package org.xwiki.distribution.Distribution.Models;

import java.util.ArrayList;
import java.util.List;

public class GenericScheduler<T> {
    private T entity;
    private List<Schedule> schedules;

    public GenericScheduler(T entity, List<Schedule> schedules) {
        this.entity = entity;
        this.schedules = schedules;
    }

    public T getEntity() {
        return entity;
    }

    public List<Schedule> getSchedules() {
        return schedules;
    }

    public void addSchedule(Schedule schedule) {
        if (schedules == null)
            schedules = new ArrayList<>();
        schedules.add(schedule);
    }

    public boolean isBusy(int day) {
        if (schedules != null)
            for (Schedule schedule : schedules) {
                if (schedule.getDay() == day) return true;
            }
        return false;
    }

    public int getDuration() {
        int duration = 0;
        if (schedules != null)
            for (Schedule schedule : schedules) {
                duration += schedule.getDuration();
            }
        return duration;
    }
}
