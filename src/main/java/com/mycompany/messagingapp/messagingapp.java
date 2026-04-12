package com.mycompany.messagingapp;
import java.util.Scanner;

public class messagingapp{
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
        System.out.println("Enter your password please:");
        String cellPhoneNumber = scanner.nextLine();
        System.out.println("Enter your cell phone number please:");
        
        // object for login object with all details entered by the user
        System.out.println("===Login===");
        Login login = new Login(userName, passWord, firstName, lastName, cellPhoneNumber);
        System.out.println(login.registerUser());
    }
}
    

