package Models;

import java.util.ArrayList;
import java.util.List;

public class Committee {
    List<Teacher> committee = new ArrayList<>();

    public Committee(Teacher ... teachers) {
        for(Teacher teacher:teachers) {
            committee.add(teacher);
            teacher.setCommittee(this);
        }
    }

    public void addTeacher(Teacher teacher) {
        committee.add(teacher);
        teacher.setCommittee(this);
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder("[");
        for (Teacher teacher:committee) {
            stringBuilder.append(teacher + " ");
        }
        stringBuilder.append("]");
        return stringBuilder.toString();
    }
}
