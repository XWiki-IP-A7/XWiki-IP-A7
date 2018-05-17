import entity.Professor;

import java.util.ArrayList;
import java.util.HashMap;
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

    public boolean checkComittee() {
        HashMap<String, Integer> composition = new HashMap<>();

        for (Professor professor : professorList) {
            String role = professor.getClass().getName();
            Integer count = composition.get(role);
            if (count == null)
                composition.put(role, 1);
            else
                composition.put(role, count + 1);
        }

        if (composition.get("entity.President") != 1 && composition.get("entity.President") >0)
            return false;
        if(composition.get("entity.Secretar") !=1 && composition.get("entity.Secretar")>0)
            return false;
        if(composition.get("entity.Member") == 0 || composition.get("entity.Member") > 2)
            return false;
        return true;
    }
}
