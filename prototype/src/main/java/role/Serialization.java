package role;

public class Serialization {

    private Registration registration;

    public Serialization(Registration registration) {
        this.registration = registration;
    }

    public void save() {
        System.out.println("Saving " + registration.getCandidates());
    }

}