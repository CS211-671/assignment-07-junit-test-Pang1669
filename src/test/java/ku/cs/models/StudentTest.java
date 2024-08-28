package ku.cs.models;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class StudentTest {

    private Student student;

    @BeforeEach
    public void setUp() {
        student = new Student("12345", "John Doe");
    }

    @Test
    public void testConstructorWithTwoParameters() {
        assertEquals("12345", student.getId());
        assertEquals("John Doe", student.getName());
        assertEquals(0.0, student.getScore(), 0.01);
    }

    @Test
    public void testConstructorWithThreeParameters() {
        Student studentWithScore = new Student("54321", "Jane Doe", 85.5);
        assertEquals("54321", studentWithScore.getId());
        assertEquals("Jane Doe", studentWithScore.getName());
        assertEquals(85.5, studentWithScore.getScore(), 0.01);
    }

    @Test
    public void testChangeName() {
        student.changeName("Alice");
        assertEquals("Alice", student.getName());

        student.changeName(" ");
        assertEquals("Alice", student.getName());
    }

    @Test
    public void testAddScore() {
        student.addScore(25);
        assertEquals(25.0, student.getScore(), 0.01);

        student.addScore(-5);
        assertEquals(25.0, student.getScore(), 0.01); // Score should not change when adding negative value
    }

    @Test
    public void testGrade() {
        student.addScore(85);
        assertEquals("A", student.grade());

        student.addScore(-10);
        assertEquals("A", student.grade()); // No negative impact from a negative score

        student = new Student("54321", "Jane Doe", 75);
        assertEquals("B", student.grade());

        student = new Student("54321", "Jane Doe", 65);
        assertEquals("C", student.grade());

        student = new Student("54321", "Jane Doe", 55);
        assertEquals("D", student.grade());

        student = new Student("54321", "Jane Doe", 45);
        assertEquals("F", student.grade());
    }

    @Test
    public void testIsId() {
        assertTrue(student.isId("12345"));
        assertFalse(student.isId("54321"));
    }

    @Test
    public void testToString() {
        String expectedString = "{id: '12345', name: 'John Doe', score: 0.0}";
        assertEquals(expectedString, student.toString());
    }
}
