package Models;

import org.junit.jupiter.api.Test;


import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class TeacherTest {

    @Test
    void getName() {
        Teacher t = new Teacher(1,"teacher");
        assertEquals("teacher",t.getName());
    }

    @Test
    void getId() {
        Teacher t = new Teacher(1,"teacher");
        assertEquals(1,t.getId());
    }

    @Test
    void setCommittee() {
        Teacher t1 =new Teacher (1,"teacher" +1 );

        Committee c =new Committee();
       /* for (int i=1;i<=3;i++)
        { Teacher t = new Teacher(i,"teacher"+i);
          c.addCommitteeTeacher(t);

        }*/
        t1.setCommittee(c);
        assertEquals(c,t1.getCommittee());
    }

    @Test
    void getCommittee() {
        Teacher t1 =new Teacher (1,"teacher" +1 );
        Committee c =new Committee();

        t1.setCommittee(c);
        assertEquals(c,t1.getCommittee());
    }

    @Test
    void getStudents() {
        Teacher t =new Teacher(1,"teacher");
        List<Student>  l1 =new ArrayList<>();
         for (int i=0;i<3;i++)
         {  Student s=new Student(""+i,"student"+i);
           l1.add(s);
            t.addStudent(s);
         }
        System.out.println("getStudents Test");
        for (Student student: l1
             ) {
            System.out.println(student.getName()+"   "+student.getNr_matricol());

        }
     
         assertEquals(l1,t.getStudents());
    }

    @Test
    void addStudent() {
        Teacher t =new Teacher(1,"teacher");
        Student s=new Student(""+1,"student"+1);
        t.addStudent(s);

        assertEquals(s, t.getStudents().get(t.getStudents().size() - 1));

    }

    /*@Test
    void toString() {
    }*/
}