public class Student {
    private String numarMatricol;
    private String nume;
    private String prenume;
    private int totalProba1;
    private int totalProba2;

    public Student(String numarMatricol, String nume, String prenume) {
        this.numarMatricol = numarMatricol;
        this.nume = nume;
        this.prenume = prenume;
        this.totalProba1 = 0;
        this.totalProba2 = 0;
    }

    public void noteazaProba1(int valoare) {
        this.totalProba1 += valoare;
    }

    public void noteazaProba2(int valoare) {
        this.totalProba2 += valoare;
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

    public int getTotalProba1() {
        return totalProba1;
    }

    public void setTotalProba1(int totalProba1) {
        this.totalProba1 = totalProba1;
    }

    public int getTotalProba2() {
        return totalProba2;
    }

    public void setTotalProba2(int totalProba2) {
        this.totalProba2 = totalProba2;
    }
}
