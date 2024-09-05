
package assignment11;

import java.io.IOException;
import java.util.Scanner;
import models.*;
public class Assignment11 {

    public static void main(String[] args) throws Exception {
        int option;
        Scanner scan = new Scanner(System.in);
        AccountManagement accountManagement = new AccountManagement();
        // Form for account management
        do{
           System.out.println("Press 0 to dismiss this form");
           System.out.println("Press 1 to Admin");
           System.out.println("Press 2 to User");
           option =  scan.nextInt();
           switch(option)
           {
               case 0:{
                   break;
               }
               case 1:{
                   System.out.print("Enter your email and password for admin login");
                   String email1 = "imran@gmail.com";
                   String password1 = "12345";
                   System.out.print("Enter your email");
                   String email = scan.next();
                   System.out.print("Enter your password");
                   String password = scan.next();
                   if(email.isEmpty() || password.isEmpty())
                   {
                       System.out.println("Email or password is required");
                   } else if (email.equals(email1) && password.equals(password1))
                   {
                       int adminOption;
                       do{
                          System.out.println("Press 0 to dismiss admin form");
                          System.out.println("Press 1 to create account");
                          System.out.println("Press 2 to delete account");
                          System.out.println("Press 3 to update account");
                          adminOption = scan.nextInt();
                          switch(adminOption)
                          {
                              case 0 : 
                              {
                                  break;
                              }
                              case 1 : {
                                  System.out.println("Enter username");
                                  String userName = scan.next();
                                  System.out.println("Enter phone number");
                                  String phoneNumber = scan.next();
                                  System.out.println("Enter user password");
                                  String userPassword = scan.next();
                                  System.out.println("Enter user balance");
                                  int userBalance = scan.nextInt();
                                  System.out.println("Enter account number");
                                  int accountNumber = scan.nextInt();
                                  System.out.println("Enter account type if current then enter 1 or if saving then 0");
                                  int accountType = scan.nextInt();
                                  boolean myType = (accountType == 1);
                                  Account account = new Account(userName, phoneNumber, userPassword, userBalance, accountNumber, myType);
                                  try
        {
            accountManagement.createAccount(account);
        }catch(IOException e)
        {
            System.err.println(e.getMessage());
        }
                              } 
                              break;
                              case 2 : {
                                  System.out.print("Enter account number");
                                  int accountNumber = scan.nextInt();
                                  accountManagement.deleteAccount(accountNumber);
                                  break;
                              }
                              case 3 : {
                                  System.out.println("Enter username to update");
                                  String userName = scan.next();
                                  System.out.println("Enter phone number to update");
                                  String phoneNumber = scan.next();
                                  System.out.println("Enter user password to update");
                                  String userPassword = scan.next();
                                  System.out.println("Enter user balance to update");
                                  int userBalance = scan.nextInt();
                                  System.out.println("Enter account number to update");
                                  int accountNumber = scan.nextInt();
                                  System.out.println("Enter account type if current then enter 1 or if saving then 0");
                                  int accountType = scan.nextInt();
                                  boolean myType = (accountType == 1);
                                  Account account = new Account(userName, phoneNumber, userPassword, userBalance, accountNumber, myType);
                                  accountManagement.updateAccount(accountNumber, account);
                              }
                              default : {
                                  System.out.println("Incorrect option");
                                  break;
                              }
                          }
                       }while(adminOption != 0);
                   }
                   else{
                       System.out.println("Incorrect Email or password");
                   }
                   break;
               }
               case 2:{
                   int userOption;
                   do{
                      System.out.println("Press 0 to dismiss this form");
                      System.out.println("Press 1 to Deposit money");
                      System.out.println("Press 2 to Withdraw money"); 
                      userOption = scan.nextInt();
                      switch(userOption)
                      {
                          case 0:{
                              break;
                          }
                          case 1: {
                              System.out.println("Enter money");
                              int money = scan.nextInt();
                              System.out.println("Enter account number");
                              int accountNumber = scan.nextInt();
                              System.out.println("Enter account type if current then enter 1 or if saving then 0");
                                  int accountType = scan.nextInt();
                                  boolean myType = (accountType == 1);
                              accountManagement.depositMoney(money, accountNumber, myType);
                              break;
                          }
                          case 2 : {
                              System.out.println("Enter money");
                              int money = scan.nextInt();
                              System.out.println("Enter account number");
                              int accountNumber = scan.nextInt();
                              System.out.println("Enter account type if current then enter 1 or if saving then 0");
                                  int accountType = scan.nextInt();
                                  boolean myType = (accountType == 1);
                              accountManagement.withdrawMoney(money, accountNumber,myType);
                              break;
                          }
                          default : {
                              System.out.println("Enter a valid option");
                              break;
                          }
                      }
                   }while(userOption != 0);
                   break;
               }
           }
        }while(option != 0);
    }
    
}
