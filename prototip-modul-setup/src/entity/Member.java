package entity;

import entity.Degree;
import entity.Professor;

/**
 * @author Victor Manoliu on 05-May-18
 */
public class Member extends Professor {

    public Member(Degree degree, String surName, String name) {
        super(degree, surName, name);
    }

}
