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
    
    // arrays to store different message types
    private static String[] sentMessages = new String[100];
    private static String[] disregardedMessages = new String[100];
    private static String[] allMessages = new String[100];
    private static String[] storedMessages = new String[100];
    private static String[] messageHashes = new String[100];
    private static String[] messageIDs = new String[100];
    private static String[] recipients = new String[100];
    private static int totalStoredCount = 0;// to track all the the arrays
    // counters to track how many are in each array
    private static int sentCount = 0;
    private static int disregardedCount = 0;
    private static int storedCount = 0;
    
    
    
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
            return "Cell phone number is incorrect or no international code try again."
                    ;
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
       if (choice == 1) {
           sentMessages[sentCount] = this.messageText;
           allMessages[totalStoredCount] = this.messageText;
           messageHashes[totalStoredCount] = this.messageHash;
           messageIDs[totalStoredCount] = this.messageID;
           recipients[totalStoredCount] = this.recipientNumber;
           sentCount++;
           totalStoredCount++;
           totalMessageCounter++;
             return "Message successfully sent.";
        } else if (choice == 2) {
            disregardedMessages[disregardedCount] = this.messageText;
            allMessages[totalStoredCount] = this.messageText;
            messageHashes[totalStoredCount] = this.messageHash;
            messageIDs[totalStoredCount] = this.messageID;
            recipients[totalStoredCount] = this.recipientNumber;
            disregardedCount++;
            totalStoredCount++;
             return "Press 0 to delete the message.";
        } else if (choice == 3) {
            storedMessages[storedCount] = this.messageText;
            allMessages[totalStoredCount] = this.messageText;
            messageHashes[totalStoredCount] = this.messageHash;
            messageIDs[totalStoredCount] = this.messageID;
            recipients[totalStoredCount] = this.recipientNumber;
            storedCount++;
            totalStoredCount++;
            storeMessage();
             return "Message successfully stored.";
      }
        return null;
    }
    
    public String displaySentMessages(){
        // to check there are any sent messages
        if (sentCount == 0){
            return "No messages sent yet.";
        }
        
        String results = ""; /* this will loop through
        all sent messages*/
        for (int i = 0; i < sentCount; i++ ){
        results += "Message" + (i + 1) + sentMessages[i] + "\n";
     }
        return results;
  }
    public String longestMessage(){
        // checking if there are any sent messages
        if (sentCount == 0){
            return "No mesages sent yet.";
        }
        // i start to assume the first message is long
        String longest = sentMessages[0];
        // looping through and comparing each message
        for (int i = 1; i < sentCount; i++){
          if (sentMessages[i].length() > longest.length()){
               longest = sentMessages[i];
          }
        }
        return "Longest message:" + longest;
    }
    
    public String searchByMessageID(String searchID) {
    for (int i = 0; i < sentCount; i++) {
        if (messageIDs[i] != null && messageIDs[i].equals(searchID)) {
            return "Recipient: " + recipients[i] + "\nMessage: " + allMessages[i];
        }
    }
    return "Message ID not found.";
}
    
    public String searchByRecipient(String searchRecipient) {
         String result = "";
             for (int i = 0; i < totalStoredCount; i++) {
                if (recipients[i] != null && recipients[i].equals(searchRecipient)) {
                  result += allMessages[i] + "\n";
        }
    }
    if (result.isEmpty()) {
        return "No messages found for this recipient.";
    }
    return result;
}
    
     
    public String deleteMessage(String searchHash) {
    for (int i = 0; i < totalStoredCount; i++) {
        if (messageHashes[i] != null && messageHashes[i].equals(searchHash)) {
            String deleted = allMessages[i];
            allMessages[i] = null;
            messageHashes[i] = null;
            messageIDs[i] = null;
            recipients[i] = null;
            return "Message: \"" + deleted + "\" successfully deleted.";
        }
    }
    return "Message hash not found.";
}
    
    public String displayReport(){
        // checking if there are any sent messages
        if(totalStoredCount == 0){
            return "No messages sent yet.";
        }
         
        String report = "== Message Report ==";
        // loop through all messages
        for(int i = 0; i < totalStoredCount; i++){
            if(allMessages[i] != null){
                report += "Message:" + (i + 1) + ":\n" +
                          "Message Hash:" + messageHashes[i] + "\n" 
                        + "Recipient:" + recipients[i] + "\n" +
                          "Message:" + allMessages[i];
            }
        }
        return report;
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
      // get first 2 digits of the message ID
      String firstTwoDigits = messageID.substring(0,2);
      // split message into words
      String[] words = messageText.split(" ");
      // get first and last word
      String firstWord = words[0];
      String lastWord = words[words.length - 1];
      // combine and make uppercase
      String hash = firstTwoDigits + ":" + numMessagesSent 
              + ":" + firstWord + lastWord;
        return hash.toUpperCase();
              
        
    }

    public String getMessageID() {
        return messageID;
    }

    public int getNumMessagesSent() {
        return numMessagesSent;
    }

    public String getRecipientNumber() {
        return recipientNumber;
    }

    public String getMessageText() {
        return messageText;
    }

    public String getMessageHash() {
        return messageHash;
    }
    
    
    
    
}
    
    
        
    
    
















