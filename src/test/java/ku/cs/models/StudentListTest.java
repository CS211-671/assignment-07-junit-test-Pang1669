package ku.cs.models;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class StudentListTest {
    @Test
    void testAddNewStudent(){
        StudentList sl1 = new StudentList();
        sl1.addNewStudent("6xxxxx1","A",50);

        assertEquals("A",sl1.findStudentById("6xxxxx1").getName());
        assertEquals(50,sl1.findStudentById("6xxxxx1").getScore());
    }


    @Test
    void testFindStudentById(){
        StudentList sl1 = new StudentList();
        sl1.addNewStudent("6xxxxx1","A",50);
        sl1.addNewStudent("6xxxxx2","B",60);
        sl1.addNewStudent("6xxxxx3","C",70);

        assertEquals("A",sl1.findStudentById("6xxxxx1").getName());
    }

    @Test
    void testGiveScoreToId(){
        StudentList sl1 = new StudentList();
        sl1.addNewStudent("6xxxxx1","A",50);
        sl1.addNewStudent("6xxxxx2","B",60);
        sl1.addNewStudent("6xxxxx3","C",70);

        sl1.giveScoreToId("6xxxxx1",20);
        assertEquals(70,sl1.findStudentById("6xxxxx1").getScore());

        sl1.giveScoreToId("6xxxxx2",-10);
        assertEquals(60,sl1.findStudentById("6xxxxx2").getScore());
    }

    @Test
    void testViewGradeOfId(){
        StudentList sl1 = new StudentList();
        sl1.addNewStudent("6xxxxx1","A",50);
        sl1.addNewStudent("6xxxxx2","B",60);
        sl1.addNewStudent("6xxxxx3","C",70);
        assertEquals("D",sl1.viewGradeOfId("6xxxxx1"));
    }

}