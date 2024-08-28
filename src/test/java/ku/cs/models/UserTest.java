package ku.cs.models;

import at.favre.lib.crypto.bcrypt.BCrypt;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;


import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import at.favre.lib.crypto.bcrypt.BCrypt;

public class UserTest {

    private User user;

    @BeforeEach
    public void setUp() {
        user = new User("testuser");
    }

    @Test
    public void testConstructorWithUsernameOnly() {
        assertEquals("testuser", user.getUsername());
        assertNull(user.getPassword()); // Password should be null initially
    }

    @Test
    public void testConstructorWithUsernameAndPassword() {
        user = new User("testuser", "testpassword");
        assertEquals("testuser", user.getUsername());
        assertNotNull(user.getPassword()); // Password should be hashed and not null
        assertTrue(user.validatePassword("testpassword")); // Password should be valid
    }

    @Test
    public void testIsUsername() {
        assertTrue(user.isUsername("testuser"));
        assertFalse(user.isUsername("wronguser"));
    }

    @Test
    public void testSetPassword() {
        user.setPassword("newpassword");
        String hashedPassword = user.getPassword();
        assertNotNull(hashedPassword);
        assertNotEquals("newpassword", hashedPassword); // Password should be hashed
        assertTrue(user.validatePassword("newpassword")); // Password should be valid
    }

    @Test
    public void testValidatePassword() {
        user.setPassword("mypassword");
        assertTrue(user.validatePassword("mypassword")); // Correct password
        assertFalse(user.validatePassword("wrongpassword")); // Incorrect password
    }

    @Test
    public void testGetUsername() {
        assertEquals("testuser", user.getUsername());
    }

    @Test
    public void testGetPassword() {
        user.setPassword("testpassword");
        String hashedPassword = user.getPassword();
        assertNotNull(hashedPassword);
        assertNotEquals("testpassword", hashedPassword); // Password should be hashed
    }
}
