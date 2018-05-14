package registration.model;

public class Teacher {

    private TeachingDegree teachingDegree;
    private String name;

    public Teacher(TeachingDegree teachingDegree, String name) {
        this.teachingDegree = teachingDegree;
        this.name = name;
    }
}