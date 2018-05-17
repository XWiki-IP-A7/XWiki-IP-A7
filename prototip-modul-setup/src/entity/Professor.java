package entity;

import static entity.Degree.*;

/**
 * @author Victor Manoliu on 05-May-18
 */
public class Professor {

    private Degree degree;
    private String surName;
    private String name;

    private final String REGEXP = "^[\\\\p{L} .'-]+$";

    public Professor(Degree degree, String surName, String name)
    {
        this.degree = degree;
        this.surName = surName;
        this.name = name;
    }

    public boolean checkProfessor() {
        if ((getDegree().equals(Colab) ? 1 : 0) + (getDegree().equals(Asist) ? 1 : 0) + (getDegree().equals(Lect) ? 1 : 0) + (getDegree().equals(Prof) ? 1 : 0) + (getDegree().equals(Conf) ? 1 : 0) == 0)
            return false;
        if (!getSurName().matches(REGEXP))
            return false;
        if (!getName().matches(REGEXP))
            return false;
        return true;
    }

    public String getName() {
        return name;
    }

    public Degree getDegree() {
        return degree;
    }

    public String getSurName() {
        return surName;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDegree(Degree degree) {
        this.degree = degree;
    }

    public void setSurName(String surMame) {
        this.surName = surMame;
    }
}
