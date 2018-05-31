package org.xwiki.distribution.Distribution.Models;

public class StudentRepartition {
    private Student student;
    private Schedule schedule;

    public StudentRepartition(Student student, Schedule schedule) {
        this.student = student;
        this.schedule = schedule;
    }

    public Student getStudent() {
        return student;
    }

    public Schedule getSchedule() {
        return schedule;
    }

    public void setSchedule(Schedule schedule) {
        this.schedule = schedule;
    }
}
