/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */

import com.mycompany.part1.Login;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author lab_services_student
 */
public class ChatAppTest {

    public ChatAppTest() {
    }

    @BeforeClass
    public static void setUpClass() {
        System.out.println("Setup Before All Tests");
    }

    @AfterClass
    public static void tearDownClass() {
        System.out.println("Cleanup After All Tests");
    }

    @Before
    public void setUp() {
        System.out.println("Setup Before Each Test");
    }

    @After
    public void tearDown() {
        System.out.println("Cleanup After Each Test");
    }

    @Test
    public void testValidUsername() {
        Login login = new Login("user$name", "Password1@");
        assertTrue("Username should be valid", login.checkUsername());
    }

    @Test
    public void testInvalidUsernameNoSymbol() {
        Login login = new Login("username", "Password1@");
        assertFalse("Username should be invalid without '$'", login.checkUsername());
    }

    @Test
    public void testValidPassword() {
        Login login = new Login("user$name", "Password1@");
        assertTrue("Password should be valid", login.checkPassword());
    }

    @Test
    public void testInvalidPasswordNoUppercase() {
        Login login = new Login("user$name", "password1@");
        assertFalse("Password should be invalid without uppercase", login.checkPassword());
    }

    @Test
    public void testLoginSuccess() {
        Login login = new Login("user$name", "Password1@");
        boolean result = login.loginUser("user$name", "Password1@");
        assertTrue("Login should succeed", result);
    }

    @Test
    public void testLoginFailure() {
        Login login = new Login("user$name", "Password1@");
        boolean result = login.loginUser("wronguser", "wrongpass");
        assertFalse("Login should fail", result);
    }

    @Test
    public void testReturnLoginMessageSuccess() {
        Login login = new Login("user$name", "Password1@");
        String message = login.returnLogin(true);
        assertEquals("Welcome Okuhle", message);
    }

    @Test
    public void testReturnLoginMessageFailure() {
        Login login = new Login("user$name", "Password1@");
        String message = login.returnLogin(false);
        assertEquals("Invalid credentials", message);
    }
}