package entity;

import entity.Degree;
import entity.Professor;

/**
 * @author Victor Manoliu on 05-May-18
 */
public class Member extends Professor {

    public Member(Degree degree, String surMame, String name) {
        super(degree, surMame, name);
    }
}
