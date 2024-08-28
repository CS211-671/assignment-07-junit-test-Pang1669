package ku.cs.models;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.util.ArrayList;

public class StudentListTest {

    private StudentList studentList;

    @BeforeEach
    public void setUp() {
        studentList = new StudentList();
    }

    @Test
    public void testAddNewStudentWithoutScore() {
        studentList.addNewStudent("12345", "John Doe");
        ArrayList<Student> students = studentList.getStudents();
        assertEquals(1, students.size());
        assertEquals("12345", students.get(0).getId());
        assertEquals("John Doe", students.get(0).getName());
        assertEquals(0.0, students.get(0).getScore(), 0.01);
    }

    @Test
    public void testAddNewStudentWithScore() {
        studentList.addNewStudent("54321", "Jane Doe", 75.5);
        ArrayList<Student> students = studentList.getStudents();
        assertEquals(1, students.size());
        assertEquals("54321", students.get(0).getId());
        assertEquals("Jane Doe", students.get(0).getName());
        assertEquals(75.5, students.get(0).getScore(), 0.01);
    }

    @Test
    public void testAddNewStudentWithDuplicateId() {
        studentList.addNewStudent("12345", "John Doe");
        studentList.addNewStudent("12345", "Jane Doe"); // Duplicate ID
        ArrayList<Student> students = studentList.getStudents();
        assertEquals(1, students.size()); // Should not add duplicate ID
        assertEquals("John Doe", students.get(0).getName());
    }

    @Test
    public void testFindStudentById() {
        studentList.addNewStudent("12345", "John Doe");
        Student student = studentList.findStudentById("12345");
        assertNotNull(student);
        assertEquals("John Doe", student.getName());

        Student nonExistent = studentList.findStudentById("54321");
        assertNull(nonExistent);
    }

    @Test
    public void testGiveScoreToId() {
        studentList.addNewStudent("12345", "John Doe");
        studentList.giveScoreToId("12345", 50.0);
        Student student = studentList.findStudentById("12345");
        assertNotNull(student);
        assertEquals(50.0, student.getScore(), 0.01);

        studentList.giveScoreToId("54321", 30.0); // Non-existent student
        assertNull(studentList.findStudentById("54321"));
    }

    @Test
    public void testViewGradeOfId() {
        studentList.addNewStudent("12345", "John Doe", 85.0);
        String grade = studentList.viewGradeOfId("12345");
        assertEquals("A", grade);

        String nonExistentGrade = studentList.viewGradeOfId("54321");
        assertNull(nonExistentGrade); // Non-existent student
    }

    @Test
    public void testGetStudents() {
        studentList.addNewStudent("12345", "John Doe");
        studentList.addNewStudent("54321", "Jane Doe", 75.5);
        ArrayList<Student> students = studentList.getStudents();
        assertEquals(2, students.size());
    }
}
