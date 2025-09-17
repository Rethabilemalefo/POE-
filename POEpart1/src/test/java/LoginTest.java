/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */

import com.mycompany.poepart1.Login;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author RC_Student_lab
 */
public class LoginTest {
    
    
    
    public LoginTest() {
    }
    
    
    // 1. Username correctly formatted
    @Test
    public void testValidUserName() {
        Login user = new Login("kyl_1", "Password1!", "+27838968976");
        assertTrue(user.checkUserName());
    }

    // 2. Username incorrectly formatted
    @Test
    public void testInvalidUserName() {
        Login user = new Login("kyle!!!!!!", "Password1!", "+27838968976");
        assertFalse(user.checkUserName());
    }

    // 3. Password meets complexity
    @Test
    public void testValidPassword() {
        Login user = new Login("kyl_1", "Ch&&sec@ke991", "+27838968976");
        assertTrue(user.checkPasswordComplexity());
    }

    // 4. Password fails complexity
    @Test
    public void testInvalidPassword() {
        Login user = new Login("kyl_1", "password", "+27838968976");
        assertFalse(user.checkPasswordComplexity());
    }

    // 5. Cell phone correctly formatted
    @Test
    public void testValidCellPhone() {
        Login user = new Login("kyl_1", "Password1!", "+27838968976");
        assertTrue(user.checkCellPhoneNumber());
    }

    // 6. Cell phone incorrectly formatted
    @Test
    public void testInvalidCellPhone() {
        Login user = new Login("kyl_1", "Password1!", "08966553");
        assertFalse(user.checkCellPhoneNumber());
    }

    // 7. Successful login
    @Test
    public void testSuccessfulLogin() {
        Login user = new Login("kyl_1", "Password1!", "+27838968976");
        user.loginUser("kyl_1", "Password1!");
        assertEquals("Welcome Kyl,it is great to see you again.", user.returnLoginStatus());
    }

    // 8. Failed login
    @Test 
    public void testFailedLogin() {
        Login user = new Login("kyl_1", "Password1!", "+27838968976");
        user.loginUser("wrong", "wrong");
        assertEquals("Username or password incorrect, please try again.", user.returnLoginStatus());
    }
}


    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    // @Test
    // public void hello() {}

