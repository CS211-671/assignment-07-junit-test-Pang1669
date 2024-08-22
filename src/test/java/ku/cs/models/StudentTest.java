package ku.cs.models;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class StudentTest {
    Student s1;

    @BeforeEach
    void init(){
         s1 = new Student("6xxxxx", "kong");
    }

    @Test
    void testAddScore(){
    //    Student s1 = new Student("6xxxxxxx", "kong");
        s1.addScore(40);
        assertEquals(40,s1.getScore());
    }

    @Test
    void testCalculateGrade(){
    //    Student s1 = new Student("6xxxxx","kong",58);
        s1.addScore(10);
        assertEquals("C",s1.grade());
    }

}