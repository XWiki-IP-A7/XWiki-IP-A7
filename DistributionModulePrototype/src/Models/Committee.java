package Models;

import java.util.ArrayList;
import java.util.List;

public class Committee {
    List<Teacher> committee = new ArrayList<>();
    private Teacher auxiliaryTeacher;

    public Committee(Teacher... teachers) {
        for (Teacher teacher : teachers) {
            committee.add(teacher);
            teacher.setCommittee(this);
        }
    }

    public void addTeacher(Teacher teacher) {
        committee.add(teacher);
        teacher.setCommittee(this);
    }

    public Teacher getAuxiliaryTeacher() {
        return auxiliaryTeacher;
    }

    public void setAuxiliaryTeacher(Teacher auxiliaryTeacher) {
        auxiliaryTeacher.setCommittee(this);
        this.auxiliaryTeacher = auxiliaryTeacher;
    }

    public int getNumberOfStudents() {
        int numberOfStudents = 0;
        for (Teacher teacher:committee) {
            numberOfStudents += teacher.getStudents().size();
        }
        if (auxiliaryTeacher != null)
            numberOfStudents += auxiliaryTeacher.getStudents().size();
        return numberOfStudents;
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder("[");
        for (Teacher teacher : committee) {
            stringBuilder.append(teacher + " ");
        }
        if (auxiliaryTeacher != null)
            stringBuilder.append("|" + auxiliaryTeacher + "| ");
        stringBuilder.delete(stringBuilder.length() - 1, stringBuilder.length());
        stringBuilder.append("]");
        return stringBuilder.toString();
    }
}
