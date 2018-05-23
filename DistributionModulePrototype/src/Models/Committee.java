package Models;

import java.util.ArrayList;
import java.util.List;

public class Committee {
    private List<Teacher> committee;
    private List<Teacher> auxiliaryTeachers;
    private List<Teacher> constraintTeachers;

    public Committee(Teacher... teachers) {
        committee = new ArrayList<>();
        for (Teacher teacher : teachers) {
            if (teacher.getCommittee() == null) {
                committee.add(teacher);
                teacher.setCommittee(this);
            }
        }
    }

    public void addCommitteeTeacher(Teacher teacher) {
        if (committee == null)
            committee = new ArrayList<>();
        addTeacher(committee, teacher);
    }

    public void addConstraintTeacher(Teacher teacher) {
        if (constraintTeachers == null)
            constraintTeachers = new ArrayList<>();
        addTeacher(constraintTeachers, teacher);
    }

    public void addAuxiliaryTeacher(Teacher teacher) {
        if (auxiliaryTeachers == null)
            auxiliaryTeachers = new ArrayList<>();
        addTeacher(auxiliaryTeachers, teacher);
    }

    private void addTeacher(List<Teacher> teachers, Teacher teacher) {
        if (teacher.getCommittee() == null) {
            teachers.add(teacher);
            teacher.setCommittee(this);
        }
    }

    public int getNumberOfStudents() {
        int numberOfStudents = 0;
        numberOfStudents += getNumberOfStudents(committee);
        numberOfStudents += getNumberOfStudents(constraintTeachers);
        numberOfStudents += getNumberOfStudents(auxiliaryTeachers);
        return numberOfStudents;
    }

    private int getNumberOfStudents(List<Teacher> teachers) {
        int noOfStudents = 0;
        if (teachers != null)
            for (Teacher teacher : teachers) {
                if (teacher.getStudents() != null)
                    noOfStudents += teacher.getStudents().size();
            }
        return noOfStudents;
    }

    public int getNumberOfTeachers() {
        int numberOfTeachers = 0;
        numberOfTeachers += getNumberOfTeachers(committee);
        numberOfTeachers += getNumberOfTeachers(constraintTeachers);
        numberOfTeachers += getNumberOfTeachers(auxiliaryTeachers);
        return numberOfTeachers;
    }

    private int getNumberOfTeachers(List<Teacher> teachers) {
        if (teachers != null)
            return teachers.size();
        else return 0;
    }

    public void reset() {
        resetSetOfTeachers(auxiliaryTeachers);
        resetSetOfTeachers(constraintTeachers);
        auxiliaryTeachers = null;
        constraintTeachers = null;
    }

    private void resetSetOfTeachers(List<Teacher> teachers) {
        if (teachers != null) {
            for (Teacher teacher : teachers) {
                if (teacher != null)
                    teacher.setCommittee(null);
            }
        }
    }

    public Teacher getFullestCommitteeTeacher() {
        return getFullestTeacher(constraintTeachers);
    }

    public Teacher getFullestTeacher() {
        Teacher fullestTeacher = getFullestTeacher(committee);
        Teacher auxTeacher = getFullestTeacher(constraintTeachers);
        if (fullestTeacher == null)
            fullestTeacher = auxTeacher;
        else if (auxTeacher != null && auxTeacher.getNumberOfStudents() > fullestTeacher.getNumberOfStudents())
            fullestTeacher = auxTeacher;
        auxTeacher = getFullestTeacher(auxiliaryTeachers);
        if (fullestTeacher == null)
            fullestTeacher = auxTeacher;
        else if (auxTeacher != null && auxTeacher.getNumberOfStudents() > fullestTeacher.getNumberOfStudents())
            fullestTeacher = auxTeacher;
        return fullestTeacher;
    }

    private Teacher getFullestTeacher(List<Teacher> teachers) {
        if (teachers == null) {
            return null;
        }
        int maxStudents = Integer.MIN_VALUE;
        Teacher fullestTeacher = null;
        for (Teacher teacher : teachers) {
            if (maxStudents < teacher.getStudents().size())
                maxStudents = teacher.getStudents().size();
            fullestTeacher = teacher;
        }
        return fullestTeacher;
    }

    public List<Teacher> getTeachers() {
        List<Teacher> teachers = null;
        if (committee != null) {
            teachers = new ArrayList<>();
            teachers.addAll(committee);
            if (constraintTeachers != null)
                teachers.addAll(constraintTeachers);
            if (auxiliaryTeachers != null)
                teachers.addAll(auxiliaryTeachers);
        }
        return teachers;
    }

    public boolean isCommitteeTeacher(Teacher teacher) {
        if (committee != null)
            return committee.contains(teacher);
        return false;
    }

    public List<Teacher> getMembers() {
        List<Teacher> teachers = null;
        if (committee != null) {
            teachers = new ArrayList<>();
            teachers.addAll(committee);
        }
        return teachers;
    }

    public List<Teacher> getAuxiliaryMembers() {
        List<Teacher> teachers = null;
        if (constraintTeachers != null) {
            teachers = new ArrayList<>();
            teachers.addAll(constraintTeachers);
        }
        if (auxiliaryTeachers != null) {
            if (teachers == null)
                teachers = new ArrayList<>();
            teachers.addAll(auxiliaryTeachers);

        }
        return teachers;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder("[");

        if (committee != null)
            for (Teacher teacher : committee) {
                stringBuilder.append(teacher + " ");
            }

        if (constraintTeachers != null)
            for (Teacher teacher : constraintTeachers) {
                stringBuilder.append("*" + teacher + "* ");
            }

        if (auxiliaryTeachers != null)
            for (Teacher teacher : auxiliaryTeachers) {
                stringBuilder.append("|" + teacher + "| ");
            }
        if (stringBuilder.toString().endsWith(" "))
            stringBuilder.delete(stringBuilder.length() - 1, stringBuilder.length());
        stringBuilder.append("]");

        return stringBuilder.toString();
    }

    public String toString(Student student) {
        StringBuilder stringBuilder = new StringBuilder("[");

        if (committee != null)
            for (Teacher teacher : committee) {
                stringBuilder.append(teacher + " ");
            }

        if (!committee.contains(student.getCoordinator()))
            if (constraintTeachers != null)
                if (constraintTeachers.contains(student.getCoordinator()))
                    stringBuilder.append("*" + student.getCoordinator() + "*");
                else stringBuilder.append("|" + student.getCoordinator() + "|");
        if (stringBuilder.toString().endsWith(" "))
            stringBuilder.delete(stringBuilder.length() - 1, stringBuilder.length());
        stringBuilder.append("]");
        return stringBuilder.toString();
    }
}
