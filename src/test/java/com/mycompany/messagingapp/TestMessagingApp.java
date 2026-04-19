package com.mycompany.messagingapp;
import com.mycompany.messagingapp.Login;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;


public class TestMessagingApp {
         // correct test data from assignment
        Login correctLogin = new Login("kyl_1", "Ch&&sec@ke99!!", "Kyle","Smith", "+278388968976");
        
        //incorrect test data from assignment is entered data is incorrect
        Login incorrectLogin = new Login("kyl!!!!!!", "password", "Kyle", "Smith", "03838968976");
    
    
    public TestMessagingApp() {
    }
    
    @BeforeAll
    public static void setUpClass() {
    }
    
    @AfterAll
    public static void tearDownClass() {
    }
    
    @BeforeEach
    public void setUp() {
    }
    
    @AfterEach
    public void tearDown() {
    }
    @Test
       public void testUserNameisCorrect(){
           assertTrue(correctLogin.checkUserName());
           
       }
    @Test
      public void testUserNameisIncorrect(){
          assertFalse(incorrectLogin.checkUserName());
      }
      @Test 
      public void testPassWordComplexityisCorrect(){
          assertTrue(correctLogin.checkPasswordComplexity());
      }
    @Test
    public void testPassWordComplexityisIncorrect(){
         assertFalse(incorrectLogin.checkPasswordComplexity());
    }
    @Test
    public void testCellPhoneNumberisCorrect(){
         assertTrue(correctLogin.checkCellPhoneNumber());
    }
    @Test
    public void testCellPhoneNumberisIncorrect(){
        assertFalse(incorrectLogin.checkCellPhoneNumber());
    }
    @Test
    public void testLoginSuccessisCorrect(){
        assertTrue(correctLogin.loginUser("kyl_1", "Ch&&sec@ke99!!"));
    }
    @Test
    public void testLoginisIncorrect(){
        assertFalse(incorrectLogin.loginUser("wrongUser", "wrongPass"));
    }
}
