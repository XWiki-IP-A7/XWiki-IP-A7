package org.xwiki.commons.Distribution.Models;

import java.util.ArrayList;
import java.util.List;

public class Committee
{
    private List<Teacher> committee = new ArrayList<>();
    private List<Teacher> auxiliaryTeachers;
    private List<Teacher> constraintTeachers;

    public Committee(Teacher... teachers)
    {
        committee = new ArrayList<>();
        for (Teacher teacher : teachers)
        {
            if (teacher.getCommittee() == null)
            {
                committee.add(teacher);
                teacher.setCommittee(this);
            }
        }
    }

    public void addCommitteeTeacher(Teacher teacher)
    {
        if (committee == null)
            committee = new ArrayList<>();
        addTeacher(committee, teacher);
    }

    public void addConstraintTeacher(Teacher teacher)
    {
        if (constraintTeachers == null)
            constraintTeachers = new ArrayList<>();
        addTeacher(constraintTeachers, teacher);
    }

    public void addAuxiliaryTeacher(Teacher teacher)
    {
        if (auxiliaryTeachers == null)
            auxiliaryTeachers = new ArrayList<>();
        addTeacher(auxiliaryTeachers, teacher);
    }

    private void addTeacher(List<Teacher> teachers, Teacher teacher)
    {
        if (teacher.getCommittee() == null)
        {
            teachers.add(teacher);
            teacher.setCommittee(this);
        }
    }

    public int getNumberOfStudents()
    {
        int numberOfStudents = 0;
        numberOfStudents += getNumberOfStudents(committee);
        numberOfStudents += getNumberOfStudents(constraintTeachers);
        numberOfStudents += getNumberOfStudents(auxiliaryTeachers);
        return numberOfStudents;
    }

    private int getNumberOfStudents(List<Teacher> teachers)
    {
        int noOfStudents = 0;
        if (teachers != null)
            for (Teacher teacher : teachers)
            {
                if (teacher.getStudents() != null)
                    noOfStudents += teacher.getStudents().size();
            }
        return noOfStudents;
    }

    private List<Student> getAllStudents()
    {
        List<Student> studentList = new ArrayList<>();
        if (committee != null)
            committee.forEach(e -> studentList.addAll(e.getStudents()));
        if (auxiliaryTeachers != null)
            auxiliaryTeachers.forEach(e -> studentList.addAll(e.getStudents()));
        if (constraintTeachers != null)
            constraintTeachers.forEach(e -> studentList.addAll(e.getStudents()));
        return studentList;
    }

    public String toString()
    {
        StringBuilder stringBuilder = new StringBuilder("\n\n[");

        if (committee != null)
            for (Teacher teacher : committee)
            {
                stringBuilder.append(teacher + " ");
            }

        if (constraintTeachers != null)
            for (Teacher teacher : constraintTeachers)
            {
                stringBuilder.append("*" + teacher + "* ");
            }

        if (auxiliaryTeachers != null)
            for (Teacher teacher : auxiliaryTeachers)
            {
                stringBuilder.append("|" + teacher + "| ");
            }
        if (stringBuilder.toString().endsWith(" "))
            stringBuilder.delete(stringBuilder.length() - 1, stringBuilder.length());
        stringBuilder.append("]");

        stringBuilder.append(" -> " + getNumberOfStudents() + " de studenti:\n");

        getAllStudents().forEach(e -> stringBuilder.append(e.getName() + ", "));

        return stringBuilder.toString();
    }
}
