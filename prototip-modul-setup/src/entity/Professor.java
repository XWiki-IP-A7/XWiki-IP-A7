package entity;

/**
 * @author Victor Manoliu on 05-May-18
 */
public class Professor {

    private Degree degree;
    private String surMame;
    private String name;

    public Professor(Degree degree, String surMame, String name)
    {
        this.degree = degree;
        this.surMame = surMame;
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public Degree getDegree() {
        return degree;
    }

    public String getSurMame() {
        return surMame;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDegree(Degree degree) {
        this.degree = degree;
    }

    public void setSurMame(String surMame) {
        this.surMame = surMame;
    }
}
