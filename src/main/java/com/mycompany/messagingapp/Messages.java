package com.mycompany.messagingapp;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Random;

public class Messages {
    
    // Varriable declaration
    private String messageID;
    private int numMessagesSent;
    private String recipientNumber;
    private String messageText;
    private String messageHash;

    public Messages(String messageID, int numMessagesSent, String recipientNumber, String messageText) {
        this.messageID = generateRandomID();
        this.numMessagesSent = numMessagesSent;
        this.recipientNumber = recipientNumber;
        this.messageText = messageText;
        this.messageHash = createMessageHash();
        
        totalMessageCounter++;
    }
    //Random 10 digit numeric generator string
    private String generateRandomID(){
        Random rand = new Random();
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < 10; i++){
            sb.append(rand.nextInt(10));
        }
        return sb.toString();
    }
    
    
    public static int getTotalMessageCounter() {
        return totalMessageCounter;
    }

    public static void setTotalMessageCounter(int aTotalMessageCounter) {
        totalMessageCounter = aTotalMessageCounter;
    }
    
    //Accumulate total messages across the program
    private static int totalMessageCounter = 0;

    //-----Constructor-------// 

    Messages(int size, String cell, String msgContent) {
    }
    //Check if ID is within the required length
    public boolean checkMessageID(){
         return this.messageID.length() <= 10;
        
    }
    
    // validate the international code(South African must be(+27 or 0))
    public String checkRecipientCell(String recipientNumber){
        if (recipientNumber != null &&(recipientNumber.startsWith("+27") || recipientNumber.startsWith("0"))){
            return "Cell phone number successfully captured.";
        } else {
            return "Cell phone number is incorrectly formatted or does "
                    + "not contain international code" + "Try again!";
        }
    }
    
    //String length checking 
   public String checkMessageLength() {
    // 1. Check if it is completely empty/null first
    if (this.messageText == null) {
        return "Message error: No message text was provided.";
    }
    
    // 2. If it's not null, check if it fits the character limit
    if (this.messageText.length() <= 250) {
        return "Message ready to send.";
    } else {
        // 3. If it's too long, calculate by how much
        int exceededBy = this.messageText.length() - 250;
        return "Message exceeds 250 characters by " + exceededBy + ", please reduce the size.";
    }
}
    /*message handeling method bassed on the user input
    which they select a choice between 1,2 or 3
    */
    public String SentMessgae(int choice){
        if (choice  == 1){
             totalMessageCounter++ ;
             return "Message successfully sent.";
        } else if (choice == 2){ 
            return "Press 0 to delete the message.";
        } else if (choice == 3){
            return "Message successfully stored.";
        }             
        return "Invalid selection.";
    }
    
    /*prints message details and displays the ID, the Hash and 
    the recipient cell and the message its self
    */
    public String printMessagaes(){
        return "Message ID:" + this.messageID + "\n" +
               "Message Hash:" + this.messageHash + "\n" +
               "Recipient:" + this.recipientNumber + "\n" +
               "Message:" + this.messageText ;
        
    }
    
    // a return for the message counter
    public int returnTolatMessages(){
        return  totalMessageCounter ;
        }
    
    /*File research of the required json file
    and you need to import java.io.FileWriter and
     java.io.IOException and a "TRY" AND a "CATCH"
    must be used
    */
    public void storeMessage(){
     // the assembly of a standard JSON text layout
     String jsonStructure = "{\n" +
            " \"messageID\": \"" + this.messageID + "\",\n" +
            " \"messageHash\": \"" + this.messageHash + "\",\n" +
            " \"recipientNumber\": \"" + this.recipientNumber + "\",\n" +
            " \"messageText\" : \"" + this.messageText + "\",\n";
  try{
    /* true instructions java to append data 
    rather than clearing old entries
    */
    FileWriter file = new FileWriter("strored_message.json", true);
    file.write(jsonStructure + "\n\n");
    file.close();// Saves and locks down the file stream safely
    System.out.println("[File System] Success: Message successfully stored in JSON file");
    }catch (IOException e){
    System.out.println("[File System] Error: Could nor save file:" + e.getMessage());
  }
    }  

    private String createMessageHash() {
       if (this.messageText != null && !this.messageText.trim().isBlank()){
            String[] words = this.messageText.split(" ");
            return words[0] + "_" + (int)(Math.random()*1000);
        }
        return "No_Hash"; 
        
    }
    
    
    
}
    
    
        
    
    
















