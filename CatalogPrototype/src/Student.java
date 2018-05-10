import java.util.ArrayList;
import java.util.List;

public class Student {
    private String numarMatricol;
    private String nume;
    private String prenume;
    private List<Grade> note = new ArrayList<>();

    public Student(String numarMatricol, String nume, String prenume) {
        this.numarMatricol = numarMatricol;
        this.nume = nume;
        this.prenume = prenume;
    }

    public String getNumarMatricol() {
        return numarMatricol;
    }

    public void setNumarMatricol(String numarMatricol) {
        this.numarMatricol = numarMatricol;
    }

    public String getNume() {
        return nume;
    }

    public void setNume(String nume) {
        this.nume = nume;
    }

    public String getPrenume() {
        return prenume;
    }

    public void setPrenume(String prenume) {
        this.prenume = prenume;
    }

    public List<Grade> getNote() {
        return note;
    }
}
