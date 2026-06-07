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
         String expected = "Message exceeds 250 characters by 50, please reduce the size.";
         
         assertEquals(expected, msgContent.checkMessageLength());
         
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
     
    Messages msg1 = new Messages("1", 1,"+27834557896", 
                "Did you get the cakes");
    Messages msg2 = new Messages("2",2, "+27838884567",
                "Where are you? You are late! I have asked you to be on time.");
    Messages msg3 = new Messages("3", 3,"+27834484567", 
                "Yohoooo, I am at your gate.");
    Messages msg4 = new Messages("4", 4,  "0838884567", 
                "It is dinner time !");
    Messages msg5 = new Messages("5", 5, "+27838884567", 
                "Ok, I am leaving without you.");
    
    @Test
    public void testSentMessagesPopulated(){
        msg1.SentMessgae(1);
        msg2.SentMessgae(1);
        // checking if they were sent successfully 
        String result1 = msg1.SentMessgae(1);
        String result2 = msg2.SentMessgae(1);
        
        assertEquals("Message successfully sent.", result1);
        assertEquals("Message successfully sent.", result2);
    }
    
    @Test
    public void testLongestMessage(){
        // msg2 is the longest messagefrom the test data
        String expected = "Longest message:Where are you? You are late!"
                + " I have asked you to be on time.";
        assertEquals(expected, msg2.longestMessage());
    }
    
    @Test
    public void testSearchByMessageID(){
        // send msg4 first so it goes the array
        msg4.SentMessgae(1);
        // search using msg4's ID
        String result = msg4.searchByMessageID(msg4.getMessageID());
        // check if it contains the message text
        assertTrue(result.contains("It is dinner time "));
    }
    
    @Test
    public void testSeachByRecipient(){
        // store msg2 and msg5 as per test data
        msg2.SentMessgae(3);
        msg5.SentMessgae(3);
        // search for recipient +27838884567
        String result = msg2.searchByRecipient("+27838884567");
        // check if it contains both messages
        assertTrue(result.contains( "Where are you? You are late!"));
    }
    
    @Test
       public void testDeleteMessage() {
          // send the message first
          msg2.SentMessgae(1);
          // try to delete using the hash
          String hash = msg2.getMessageHash();
          String result = msg2.deletMessage(hash);
    
    // just check it returns a valid string response
    assertNotNull(result);
    assertFalse(result.isEmpty());
}
    
    
    
   @Test
    public void testDisplayReport() {
       msg1.SentMessgae(1);
       String result = msg1.displayReport();
       assertFalse(result.isEmpty());
}
    
    @Test
      public void testDisregardMessage() {
         // msg3 should be disregarded
         String result = msg3.SentMessgae(2);
         assertEquals("Press 0 to delete the message.", result);
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
