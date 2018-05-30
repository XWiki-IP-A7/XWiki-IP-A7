package Algorithm;
import java.util.*;
import Models.Committee;
import Models.Constraint;
import Models.Student;
import Models.Teacher;
import org.junit.jupiter.api.Test;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import static org.junit.jupiter.api.Assertions.*;

class DegreeDistributionAlgorithmTest {

   /*
    @Test
    void partitionTeachers() {
        List<Teacher> teachers =new ArrayList<>();
         for (int i=0;i<30;i++)
        { Teacher t = new Teacher(i,"teacher"+i);
          teachers.add(t);
           for (int j=10*i;j<10*(i+1);j++)
           {
               Student s = new Student(""+i,"Student"+i);
               t.addStudent(s);

           }

        }
         List<Constraint> constraints=new ArrayList<>();
        List<Committee> committees = new ArrayList<>();
        for (int i = 0; i < 4; i++) {
            committees.add(new Committee());
        }
            for (int i = 0; i < 20; i++) {
                committees.get(i % 4).addCommitteeTeacher(teachers.get(i));
        }

        DegreeDistributionAlgorithm d = new DegreeDistributionAlgorithm();
        d.partitionTeachers(teachers,committees,constraints);
        for (Committee committee: committees )
              {
                  System.out.println(committee.getNumberOfStudents());
                  System.out.println(committee.getAuxiliaryMembers());
        }
        System.out.println("///////////////////////////////////////////////");
    }*/
    @Test
    void partitionTeachers1() {
        List<Teacher> teachers = new ArrayList<>();
        for (int i = 0; i < 30; i++) {
            Teacher t = new Teacher(i, "teacher" + i);
            teachers.add(t);
            Random random = new Random();
            int k = random.nextInt(20);
            for (int j = 0; j < k; j++) {
                Student s = new Student("" + j, "Student" + j);
                t.addStudent(s);

            }

        }
        List<Constraint> constraints = new ArrayList<>();
        List<Committee> committees = new ArrayList<>();
        for (int i = 0; i < 4; i++) {
            committees.add(new Committee());
        }
        for (int i = 0; i < 20; i++) {
            committees.get(i % 4).addCommitteeTeacher(teachers.get(i));
        }

        DegreeDistributionAlgorithm d = new DegreeDistributionAlgorithm();
        d.partitionTeachers(teachers, committees, constraints);
        int noOfStudents = 0;
        for (Teacher teacher : teachers
                ) {
            noOfStudents += teacher.getNumberOfStudents();

        }
        for (Committee committee : committees) {
            System.out.println("Numarul ideal de studenti " + noOfStudents / committees.size());
            System.out.println("Numarul de studenti din comitet" + committee.getNumberOfStudents());
            System.out.println("Membrii auxiliari dintr-o comisie" + committee.getAuxiliaryMembers());
            for (Teacher teacher : committee.getMembers()
                    ) {
                System.out.println(teacher.getId() + "  " + teacher.getNumberOfStudents());
            }

            for (Teacher teacherauxiliar : committee.getAuxiliaryMembers()
                    ) {
                System.out.println(teacherauxiliar.getId() + "  " + teacherauxiliar.getNumberOfStudents());

            }


        }
    }
    @Test
    void checkAnomalies() {
        List<Teacher> teachers = new ArrayList<>();
        for (int i = 0; i < 30; i++) {
            Teacher t = new Teacher(i, "teacher" + i);
            teachers.add(t);
            Random random = new Random();
            int k = random.nextInt(20);
            for (int j = 0; j < k; j++) {
                Student s = new Student("" + j, "Student" + j);
                t.addStudent(s);

            }

        }
        List<Constraint> constraints = new ArrayList<>();
        List<Committee> committees = new ArrayList<>();
        for (int i = 0; i < 4; i++) {
            committees.add(new Committee());
        }
        for (int i = 0; i < 20; i++) {
            committees.get(i % 4).addCommitteeTeacher(teachers.get(i));
        }
        DegreeDistributionAlgorithm d = new DegreeDistributionAlgorithm();
        d.checkAnomalies(committees);
        d.partitionTeachers(teachers, committees, constraints);
        int noOfStudents = 0;
        for (Teacher teacher : teachers
                ) {
            noOfStudents += teacher.getNumberOfStudents();

        }
        for (Committee committee : committees) {
            System.out.println("Numarul ideal de studenti " + noOfStudents / committees.size());
            System.out.println("Numarul de studenti din comitet" + committee.getNumberOfStudents());
            System.out.println("Membrii auxiliari dintr-o comisie" + committee.getAuxiliaryMembers());
            for (Teacher teacher : committee.getMembers()
                    ) {
                System.out.println(teacher.getId() + "  " + teacher.getNumberOfStudents());
            }

            for (Teacher teacherauxiliar : committee.getAuxiliaryMembers()
                    ) {
                System.out.println(teacherauxiliar.getId() + "  " + teacherauxiliar.getNumberOfStudents());

            }


        }

    }

    @Test
    void getRepartitions() {
    }

    @Test
    void checkAnomalies1() {
    }
}