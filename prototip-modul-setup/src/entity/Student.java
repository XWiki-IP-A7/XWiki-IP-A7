package entity;

/**
 * @author Victor Manoliu on 05-May-18
 */
public class Student {

    private String surName;
    private String name;
    private String nrMatricol;
    private String CNP;

    public Student(String surName, String name, String nrMatricol, String CNP)
    {
        this.surName = surName;
        this.name = name;
        this.nrMatricol = nrMatricol;
        this.CNP = CNP;
    }

    public String getSurName() {
        return surName;
    }

    public String getNrMatricol() {
        return nrMatricol;
    }

    public String getCNP() {
        return CNP;
    }

    public String getName() {
        return name;
    }

    public void setSurName(String surName) {
        this.surName = surName;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setNrMatricol(String nrMatricol) {
        this.nrMatricol = nrMatricol;
    }

    public void setCNP(String CNP) {
        this.CNP = CNP;
    }
}
