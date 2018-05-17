package entity;

import entity.Degree;
import entity.Professor;

import static entity.Degree.Asist;
import static entity.Degree.Colab;


/**
 * @author Victor Manoliu on 05-May-18
 */
public class President extends Professor {

    public President(Degree degree, String surName, String name) {
        super(degree, surName, name);
    }

    public boolean checkPresident() {
        if (getDegree().equals(Colab) || getDegree().equals(Asist))
            return false;
        if (checkProfessor())
            return false;
        return true;
    }
}
