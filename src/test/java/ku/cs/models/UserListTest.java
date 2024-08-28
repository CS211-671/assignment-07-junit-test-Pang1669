package ku.cs.models;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class UserListTest {

    private UserList userList;

    @BeforeEach
    public void setUp() {
        userList = new UserList();
        // Adding 3 users to UserList
        userList.addUser("user1", "password1");
        userList.addUser("user2", "password2");
        userList.addUser("user3", "password3");
    }

    @Test
    @DisplayName("User should be found in UserList")
    public void testUserListFindUser() {
        // Find one of the users
        User user = userList.findUserByUsername("user2");

        // Assert that UserList found the User
        String expected = "user2";
        String actual = user.getUsername();
        assertEquals(expected, actual);
    }

    @Test
    @DisplayName("User can change password")
    public void testUserCanChangePassword() {
        // Change password of one user
        boolean actual = userList.changePassword("user1", "password1", "newpassword1");

        // Assert that the user can change password
        assertTrue(actual);

        // Verify the password was changed
        User user = userList.findUserByUsername("user1");
        assertTrue(user.validatePassword("newpassword1"));
    }

    @Test
    @DisplayName("User with correct password can login")
    public void testUserListShouldReturnObjectIfUsernameAndPasswordIsCorrect() {
        // Call login() with correct username and password
        User user = userList.login("user3", "password3");

        // Assert that the User object is found
        assertNotNull(user);
        assertEquals("user3", user.getUsername());
    }

    @Test
    @DisplayName("User with incorrect password cannot login")
    public void testUserListShouldReturnNullIfUsernameAndPasswordIsIncorrect() {
        // Call login() with incorrect password
        User user = userList.login("user2", "wrongpassword");

        // Assert that the method returns null
        assertNull(user);

        // Also test with incorrect username
        User nonExistentUser = userList.login("nonexistent", "password2");
        assertNull(nonExistentUser);
    }
}
