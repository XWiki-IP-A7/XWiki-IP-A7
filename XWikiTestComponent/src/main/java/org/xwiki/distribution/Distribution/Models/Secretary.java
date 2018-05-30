package org.xwiki.distribution.Distribution.Models;

public class Secretary {
    private int id;
    private int name;

    public Secretary(int id, int name) {
        this.id = id;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public int getName() {
        return name;
    }
}
