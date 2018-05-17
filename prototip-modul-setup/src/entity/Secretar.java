package entity;

import static entity.Degree.Asist;
import static entity.Degree.Colab;

/**
 * @author Victor Manoliu on 05-May-18
 */
public class Secretar extends Professor {

    public final String REGEXP = "^[\\\\p{L} .'-]+$";

    public Secretar(Degree degree, String surName, String name) {
        super(degree, surName, name);
        }

    public boolean checkSecretar() {
        if (!checkProfessor())
            return false;
        if (getDegree().equals(Colab))
            return false;
        return true;
    }

}
