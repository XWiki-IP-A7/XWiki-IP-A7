package org.xwiki.distribution.Distribution.Models;

public class Constraint {
    private Teacher teacher;
    private Committee committee;

    public Constraint(Teacher teacher, Committee committee) {
        this.teacher = teacher;
        this.committee = committee;
    }

    public Teacher getTeacher() {
        return teacher;
    }

    public Committee getCommittee() {
        return committee;
    }
}
