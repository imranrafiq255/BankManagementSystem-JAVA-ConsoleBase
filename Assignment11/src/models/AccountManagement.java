
package models;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class AccountManagement {
    private final ArrayList<Account> currentAccounts;
    private final ArrayList<Account> savingAccounts;
    public AccountManagement()
    {
        this.currentAccounts = new ArrayList<>();
        this.savingAccounts = new ArrayList<>();
    }
    public void createAccount(Account account) throws IOException
    {
        if (account.getAccountType())
        {
            savingAccounts.forEach((account1) -> {
                if (account.getAccountNumber() == account1.getAccountNumber())
                {
                    System.out.println("Account is already created with same information");
                }
            });
            savingAccounts.add(account);
            System.out.println("Account is created successfully");
            File file = new File(account.getUserName()+".txt");
            file.createNewFile();
            try (FileWriter fileWriter = new FileWriter(file)) {
                fileWriter.write(account.getUserName()+"\n"+account.getPhoneNumber()+"\n"+account.getPassword()+"\n"+account.getAccountNumber()+"\n"+(account.getAccountType() ? "Saving Account" : "Current Account")+"\n"+account.getBalance());
            }
        }
        else{
            currentAccounts.forEach((account1) -> {
                if (account.getAccountNumber() == account1.getAccountNumber())
                {
                    System.out.println("Account is already created with same information");
                }
            });
            currentAccounts.add(account);
            System.out.println("Account is created successfully");
            File file = new File(account.getUserName()+".txt");
            file.createNewFile();
            try (FileWriter fileWriter = new FileWriter(file)) {
                fileWriter.write(account.getUserName()+"\n"+account.getPhoneNumber()+"\n"+account.getPassword()+"\n"+account.getAccountNumber()+"\n"+(account.getAccountType() ? "Saving Account" : "Current Account")+"\n"+account.getBalance());
            }
        }
    }
    public void deleteAccount(int accountNumber) throws Exception
    {
        boolean isFound = currentAccounts.removeIf(account->account.getAccountNumber() == accountNumber);
        System.out.println((isFound ? "Account is deleted successfully" : ""));
        if (!isFound)
        {
            boolean isDeleted = savingAccounts.removeIf(account->account.getAccountNumber() == accountNumber);
            if (isDeleted)
            {
                System.out.println("Account is deleted successfully");
            }
            else 
            {
                System.out.println("Account is not found");
            }
        }
    }
    public void updateAccount(int accountNumber, Account account) throws IOException
    {
        if (account.getAccountType())
        {
            currentAccounts.forEach((account1) -> {
        if (accountNumber == account1.getAccountNumber())
        {
            account1.setUserName(account.getUserName());
            account1.setPhoneNumber(account.getPhoneNumber());
            account1.setPassword(account.getPassword());
            account1.setBalance(account.getBalance());
            account1.setAccountNumber(account.getAccountNumber());
            System.out.println("Account is updated successfully");
               }
        });
        }else {
                savingAccounts.forEach((account1) -> {
        if (accountNumber == account1.getAccountNumber())
        {
            account1.setUserName(account.getUserName());
            account1.setPhoneNumber(account.getPhoneNumber());
            account1.setPassword(account.getPassword());
            account1.setBalance(account.getBalance());
            account1.setAccountNumber(account.getAccountNumber());
            System.out.println("Account is updated successfully");
            File file = new File(account.getUserName()+".txt");
            try {
                file.createNewFile();
            } catch (IOException ex) {
                System.out.println(ex.getMessage());
            }
            try (FileWriter fileWriter = new FileWriter(file)) {
                fileWriter.write(account.getUserName()+"\n"+account.getPhoneNumber()+"\n"+account.getPassword()+"\n"+account.getAccountNumber()+"\n"+(account.getAccountType() ? "Saving Account" : "Current Account")+"\n"+account.getBalance());
            } catch (IOException ex) {
                Logger.getLogger(AccountManagement.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        });}}
    
    public void depositMoney(int money, int accountNumber, boolean accountType)
    {
        if (accountType)
        {
          currentAccounts.forEach(account->{
           if(accountNumber == account.getAccountNumber())
           {
               account.setBalance(account.getBalance() + money);
               System.out.println(money+" is deposited to your account");
           }
           else{
              System.out.println("Account not found with given number"); 
           }
          });
        }else {
           savingAccounts.forEach(account->{
           if(accountNumber == account.getAccountNumber())
           {
               account.setBalance(account.getBalance() + money);
               System.out.println(money+" is deposited to your account");
           }
           else{
              System.out.println("Account not found with given number"); 
           }
          }); 
        }
    }
    public void withdrawMoney(int money, int accountNumber, boolean accountType)
    {
        System.out.print("there");
        System.out.print(currentAccounts.size());
        if (accountType)
        {
            currentAccounts.forEach(account->{
            if (accountNumber == account.getAccountNumber())
            {
                if (account.getBalance() == 0)
                {
                    System.out.println("You account is 0, please recharge your account");
                }
                else if (0<(account.getBalance() - money))
                {
                    System.out.println("You have insufficient balance");
                }
                else{
                    account.setBalance((account.getBalance()-money));
                   System.out.println("You have insufficient balance and your remaining balance is: " + account.getBalance()); 
                }
            }
            });
        }else{
            savingAccounts.forEach(account->{
            if (accountNumber == account.getAccountNumber())
            {
                if (account.getBalance() == 0)
                {
                    System.out.println("You account is 0, please recharge your account");
                }
                else if (0<(account.getBalance() - money))
                {
                    System.out.println("You have insufficient balance");
                }
                else{
                    account.setBalance((account.getBalance()-money));
                   System.out.println("You have insufficient balance and your remaining balance is: " + account.getBalance()); 
                }
            }
            });
        }
    }
}
