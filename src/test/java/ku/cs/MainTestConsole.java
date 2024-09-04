package ku.cs;

import ku.cs.models.Student;
import ku.cs.models.StudentList;
import org.junit.jupiter.api.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

import java.util.Arrays;

    public class MainTestConsole {

        @org.testng.annotations.Test
        public void testFindStudentById() {
            Student s1 = new Student("1", "John");
            Student s2 = new Student("2", "Jane");
            StudentList studentList = new StudentList(Arrays.asList(s1, s2));

            assertEquals(s1, studentList.findStudentById("1"));
            assertEquals(s2, studentList.findStudentById("2"));
            assertNull(studentList.findStudentById("3"));
        }

        @Test
        public void testFindStudentByObject() {
            Student s1 = new Student("1", "John");
            Student s2 = new Student("2", "Jane");
            StudentList studentList = new StudentList(Arrays.asList(s1, s2));

            assertEquals(s1, studentList.findStudentByObject(new Student("1", "John")));
            assertEquals(s2, studentList.findStudentByObject(new Student("2", "Jane")));
            assertNull(studentList.findStudentByObject(new Student("3", "Jake")));
        }
    }