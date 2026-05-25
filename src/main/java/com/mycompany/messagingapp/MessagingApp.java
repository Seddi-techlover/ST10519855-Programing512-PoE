package com.mycompany.messagingapp;
import java.util.Scanner;

public class MessagingApp{
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        // Object for messagingapp
        System.out.println("===Register===");
        //registration section
        System.out.println("Enter your first name please:");
        String firstName = scanner.nextLine();
        System.out.println("Enter your last name please:");
        String lastName = scanner.nextLine();
        System.out.println("Enter your username plaese:");
        String userName = scanner.nextLine();
        System.out.println("Enter your password please:");
        String passWord = scanner.nextLine();
        System.out.println("Enter your cell phone number please:");
        String cellPhoneNumber = scanner.nextLine();
        
        // object for login object with all details entered by the user
        System.out.println("===Login===");
        Login login = new Login(userName, passWord, firstName, lastName, cellPhoneNumber);
        
        System.out.println("Enter username to login please:");
        String enteredUser = scanner.nextLine();
        System.out.println("Enter password to login please:");
        String enteredPass = scanner.nextLine();
        
        System.out.println(login.registerUser());// this will print the welcome message from my login class
        System.out.println(login.returnLoginStatus(enteredUser,enteredPass));// This will display if the entred password and username are correct
       
        // a boolean to establish when the user is logged in or not
        boolean isLogged = login.loginUser(enteredUser, enteredPass);
        
        // Main application after logged in
        if(isLogged){
            System.out.println("-----Welcome to QuicChat-----");
            
            int menuChoice = 0;
            //Declaring an empty array
            Messages[] messaging = null;
            
            /*a while loop that runs till a the 
            the 3rd choice is chosen to end the program
            */
            while(menuChoice !=3){
                System.out.println("Choose an option:");
                System.out.println("1) Send Message:");
                System.out.println("2) Show recentlt sent messages:");
                System.out.println("3) Quit:");
                
                menuChoice = scanner.nextInt();
                scanner.nextLine();
                
            switch(menuChoice){
                case 1:
                    System.out.println("How may messages do wish to send:");
                    int size = scanner.nextInt();
                    scanner.nextInt();
                   
                    // an array to store the size of the input size
                    messaging = new Messages[size];
                    scanner.nextLine();
                    for(int i =0; i < size; i++){
                        System.out.println("---Entering details for message--- " + (i + 1));
                        
                        System.out.println("Enter Recipient Cell Number:");
                        String cell = scanner.nextLine();
                        
                        System.out.println("Enter Message Text:");
                        String msgContent = scanner.nextLine();
                        
                        messaging[i] = new Messages(String.valueOf(i + 1), i + 1, cell, msgContent);
                        
                        /* status method diagnosis(this is for validation
                           it checks the the checkRecipientCell and 
                           checkMessageLength
                        */
                        
                        System.out.println("[Validation]" + messaging[i].checkRecipientCell(cell));
                        System.out.println("[Validation]" + messaging[i].checkMessageLength());
                        
                       int actionChoice = 0;
                        
                        if(actionChoice == 3){
                            messaging[i].storeMessage();
                        }
                        
                        // to print the messages 
                        System.out.println("====Caputred Record Info====");
                        System.out.println(messaging[i].printMessagaes());                        
                       }
                     //Check if instances exists, then print summary counter total
                       if(messaging !=null && messaging.length > 0){
                           System.out.println("Total messages processes"
                                   + "during batch:" + size);
                       }
                       break;
                case 2:
                    System.out.println("Feature comming soon.");
                    break;
                case 3:
                    System.out.println("Exiting QuickChat. Goodbye!");
                    break;
                default:
                    System.out.println("Invalid menu option. Please try"
                            + "again");
                            
                }
            }
            
        }
        
    }
     
    
}


    

