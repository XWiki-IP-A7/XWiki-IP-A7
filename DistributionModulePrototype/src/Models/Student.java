package Models;

public class Student {
    private String nr_matricol;
    private String name;

    public Student(String nr_matricol, String name) {
        this.nr_matricol = nr_matricol;
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public String getNr_matricol() {
        return nr_matricol;
    }

    @Override
    public String toString() {
        return name;
    }
}
