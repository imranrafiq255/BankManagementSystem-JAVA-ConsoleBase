
package models;

public class Account {
    private String userName;
    private String phoneNumber;
    private String password;
    private int balance;
    private int interestRate;
    private int accountNumber;
    private boolean accountType;
    public Account(String userName, String phoneNumber, String password, int balance, int accountNumber, boolean accountType)
    {
        this.userName = userName;
        this.phoneNumber = phoneNumber;
        this.password = password;
        this.balance = balance;
        this.accountNumber = accountNumber;
        this.accountType = accountType;
    }

    public boolean getAccountType() {
        return accountType;
    }

    public void setAccountType(boolean accountType) {
        this.accountType = accountType;
    }

    public int getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(int accountNumber) {
        this.accountNumber = accountNumber;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getBalance() {
        return balance;
    }

    public void setBalance(int balance) {
        this.balance = balance;
    }

    public int getInterestRate() {
        return interestRate;
    }

    public void setInterestRate(int interestRate) {
        this.interestRate = interestRate;
    }
    
}
