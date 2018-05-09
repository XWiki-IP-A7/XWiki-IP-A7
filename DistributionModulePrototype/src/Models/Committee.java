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
}
