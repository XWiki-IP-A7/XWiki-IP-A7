import entity.Professor;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Victor Manoliu on 05-May-18
 */
public class Comittee {

    private List<Professor> professorList;

    public Comittee()
    {
        professorList = new ArrayList<>();
    }

    public List<Professor> getProfessorList() {
        return professorList;
    }

    public void setProfessorList(List<Professor> professorList) {
        this.professorList = professorList;
    }
}
