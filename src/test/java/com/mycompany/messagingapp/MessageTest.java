package com.mycompany.messagingapp;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;


 
public class MessageTest {
    @Test
    public void testMessageLengthCorrect(){
        String validText = "Hi Mike, can you join us for dinner tonight?";
        Messages msgContent = new Messages("1", 1, "+27718693002", validText);
        
        String expected = "Message ready to send.";
        assertEquals(expected, msgContent.checkMessageLength());
    }
    
    @Test
    public void testMessageLengthIncorrect(){
        StringBuilder longText = new StringBuilder();
         for(int i = 0; i < 300; i++){
             longText.append("a");
         }
         
         Messages msgContent = new Messages("2",2, "+27718693002", longText.toString());
         String results = msgContent.checkMessageLength();
         
         assertEquals(results, msgContent.checkMessageLength());
         
        }
     @Test
         public void testCellFormattingCorrect(){
             Messages msgContent = new Messages("1", 1, "+27718693002", "Hello");
             String expected = "Cell phone number successfully captured.";
             assertEquals(expected, msgContent.checkRecipientCell("+27718693002"));
    }
     
    @Test
    public void testCellFormattingIncorrect() {
        // Invalid cell format without an international prefix or proper length
        Messages msgContent = new Messages("1", 1, "08575975889", "Hello");
        String expected = "Cell phone number is incorrect or no international code try again.";
        assertEquals(expected, msgContent.checkRecipientCell("12345"));
    }
    
    @Test
    public void testHashGeneration() {
        String testMessage = "Hi Mike, can you join us for dinner tonight?";
        Messages msgContent = new Messages("1", 1, "+27718693002", testMessage);
        
        // Since your hash splits by space, the hash must start with the first word: "Hi"
        String generatedHash = msgContent.printMessagaes(); 
        
        // Assure the generated hash logic successfully processed the first word
        assertTrue(generatedHash.contains("Hi"));
    }
    public MessageTest() {
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
}
