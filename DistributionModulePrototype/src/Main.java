import Models.*;
import javafx.util.Pair;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        //Adding teachers and committees
        Teacher teacher1 = new Teacher(1,"prof1");
        Teacher teacher2 = new Teacher(2,"prof2");
        Committee comitee1 = new Committee(teacher1, teacher2);
        Teacher teacher3 = new Teacher(3,"prof3");
        Teacher teacher4 = new Teacher(4,"prof4");
        Committee comitee2 = new Committee(teacher3, teacher4);
        Teacher teacher5 = new Teacher(5,"prof5");
        Teacher teacher6 = new Teacher(6,"prof6");
        Committee comitee3 = new Committee(teacher5, teacher6);
        Teacher teacher7 = new Teacher(7,"prof7");
        Teacher teacher8 = new Teacher(8,"prof8");
        Teacher teacher9 = new Teacher(9,"prof9");

        List<Pair<Student, Teacher>> coordination = new ArrayList<>();

        //Adding students
        Student student1  = new Student("1","Gheorhe Alexandru");
        Student student2  = new Student("2","Covaliu Lucian");
        Student student3  = new Student("3","Carja Mihail");
        coordination.add(new Pair<>(student1,teacher1));
        coordination.add(new Pair<>(student2,teacher1));
        coordination.add(new Pair<>(student3,teacher1));
        Student student4  = new Student("4","Pomohaci Alexandru");
        Student student5  = new Student("5","Gafitescu Marian");
        Student student6  = new Student("6","Popescu Georgian");
        coordination.add(new Pair<>(student4,teacher2));
        coordination.add(new Pair<>(student5,teacher2));
        coordination.add(new Pair<>(student6,teacher2));
        Student student7  = new Student("7","Seniuc Bogdan");
        Student student8  = new Student("8","Martincu Petru");
        Student student9  = new Student("9","Iurescu Alexandru");
        coordination.add(new Pair<>(student7,teacher3));
        coordination.add(new Pair<>(student8,teacher3));
        coordination.add(new Pair<>(student9,teacher3));
        Student student10  = new Student("10","Gritco Sorin");
        Student student11 = new Student("11", "student11");
        Student student12 = new Student("12", "student12");
        coordination.add(new Pair<>(student10,teacher4));
        coordination.add(new Pair<>(student11,teacher4));
        coordination.add(new Pair<>(student12,teacher4));
        Student student13 = new Student("13", "student13");
        Student student14 = new Student("14", "student14");
        Student student15 = new Student("15", "student15");
        coordination.add(new Pair<>(student13,teacher5));
        coordination.add(new Pair<>(student14,teacher5));
        coordination.add(new Pair<>(student15,teacher5));
        Student student16 = new Student("16", "student16");
        Student student17 = new Student("17", "student17");
        Student student18 = new Student("18", "student18");
        coordination.add(new Pair<>(student16,teacher6));
        coordination.add(new Pair<>(student17,teacher6));
        coordination.add(new Pair<>(student18,teacher6));
        Student student19 = new Student("19", "student19");
        Student student20 = new Student("20", "student20");
        Student student21 = new Student("21", "student21");
        coordination.add(new Pair<>(student19,teacher7));
        coordination.add(new Pair<>(student20,teacher7));
        coordination.add(new Pair<>(student21,teacher7));
        Student student22 = new Student("22", "student22");
        Student student23 = new Student("23", "student23");
        Student student24 = new Student("24", "student24");
        coordination.add(new Pair<>(student22,teacher8));
        coordination.add(new Pair<>(student23,teacher8));
        coordination.add(new Pair<>(student24,teacher8));
        Student student25 = new Student("25", "student25");
        Student student26 = new Student("26", "student26");
        Student student27 = new Student("27", "student27");
        Student student28 = new Student("28", "student28");
        Student student29 = new Student("29", "student29");
        coordination.add(new Pair<>(student25,teacher9));
        coordination.add(new Pair<>(student26,teacher9));
        coordination.add(new Pair<>(student27,teacher9));
        coordination.add(new Pair<>(student28,teacher9));
        coordination.add(new Pair<>(student29,teacher9));

        for (Pair<Student, Teacher> pair : coordination) {
            System.out.println(pair.getKey() + " " + pair.getValue());
        }

    }
}
