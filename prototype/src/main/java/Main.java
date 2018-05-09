import role.FormRetriever;
import role.Registration;
import role.Serialization;

public class Main {
    public static void main(String[] args) {
        Registration registration = Registration.getInstance();
        FormRetriever retriever = new FormRetriever(registration);
        retriever.execute();
        Serialization serialization = new Serialization(registration);
        serialization.save();

    }
}
