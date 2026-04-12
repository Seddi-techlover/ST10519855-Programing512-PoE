package com.mycompany.messagingapp;

public class Login {
    
    
    // fields to store our private varriables for my login class
    private String userName;
    private String passWord;
    private String firstName;
    private String lastName;
    private String cellPhoneNumber;
    
           // MY constructor to initialize the login object withe the user details 
    public Login(String userName, String passWord, String firstName, String lastName, String cellPhoneNumber) {// start of constructor to initialize my varriables to work with the login method
        this.userName = userName;// initalizes username
        this.passWord = passWord;// initializes password
        this.firstName = firstName;// initalizes firstnamr
        this.lastName = lastName;// initalizes lastnamr
        this.cellPhoneNumber = cellPhoneNumber; // initalizes phone number
    }// end of constructor 
    
    public boolean checkUserName(){// we will use this boolean method to check the entered username
        if (userName.contains("_") && userName.length()<=5){
        // we set this condition because the username was perscribed to be five charactrs long and contain an underscore 
        return true;// this returns if the password has an underscore and is 5 characters
        } else {
            return false;
        }
    }
    
    public boolean checkPasswordComplexity(){//
        if (passWord.length()<8){
            return false;
       
            
        }
        boolean hasCapital = false; // we assume there is no capital but while looping ife we find one its true
        boolean hasNumber  = false; //we assume there is no diget or number but while looping ife we find one its true
        boolean hasSpecial = false; //we assume there is no special character but while looping ife we find one its true
        
        for (char c : passWord.toCharArray()){// the for loop checks if the user entered what was asked from the program
          if (Character.isUpperCase(c)){
              hasCapital = true;// we stop assuming because the programg will detect the capital letter
          }// we stop assuming because the program detects the capital then the code will run 
        
        if (Character.isDigit(c)){
            hasNumber = true;
        }// we stop assuming because the program detects the letter OR digit then the code will run
        if (!Character.isLetterOrDigit(c)){
            hasSpecial = true;
        }// we stop assuming because the program detects the special character then the code will run
    }// end of for loop
        return hasCapital && hasNumber && hasSpecial;
    }
    
    public boolean checkCellPhoneNumber(){
        if (cellPhoneNumber.matches("\\+27\\d{10}")){
            return true;
        }else{ 
            return false;
        }
    }
         
    public String registerUser(){// start of the register user this checks the username for correct format
        if (!checkUserName()){// if statment to check the users username is correct
            return "Usermane not correctly formatted; please ensure" + "that your username contains an underscoreand is " + "no more than five charactrs long";
        } else  if (!checkPasswordComplexity()){
           return "Password is incorrectly formatted; please ensure" + "that the password has eight characters," + "a capital letter, a number, and special character";   
        } else if (!checkCellPhoneNumber()){
            return  "Cell phone number incorrectly formatted or does not have international code e.g +2733...";
        } else {
            
        } 
        return "Username captured and confirmed.\n" + "Password captured and confirmed.\n" + "Cell phone number captured and confirmed";
    }// end of register user method
    
    
    public boolean loginUser(String enteredUser, String enteredPass){// start of loginUser method
        if (userName.equals(enteredUser) && passWord.equals(enteredPass)){// this check checks the password and username are correctly entered
            return true;
        } else {
            return false;
        }
    }// rnd of loginUser method
    
    public String returnLoginStatus(String enteredUser, String enteredPass){// start of LoginStatus method
        if (loginUser(enteredUser, enteredPass)){
            return"Welcome" + firstName + "  "  + lastName + "it nice to see you again";// this welcomes the user after registering
        } else {
            return  "Username or password incorrect,please try again";
        }
    }// end of LoginStatus method
    
   }
    
    
    
    


