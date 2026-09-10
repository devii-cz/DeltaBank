package account;

import person.AccountHolder;
import java.util.UUID;

public abstract class BankAccount {

    private String uuid;
    private AccountHolder accountHolder;
    private String accountNumber;
    private double balance;

    public BankAccount(String accountNumber, AccountHolder accountHolder) {
        this.uuid = UUID.randomUUID().toString();
        this.balance = 0;
        this.accountNumber = accountNumber;
        this.accountHolder = accountHolder;
    }

    public String getUuid() {
        return uuid;
    }

    public AccountHolder getAccountHolder() {
        return accountHolder;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public double getBalance() {
        return balance;
    }

    public void add(double amount){
        if (amount<0) {
            throw new IllegalArgumentException("nice try");
        }
        this.balance += amount;
    }

    public void sub(double amount){
        if (amount<0) {
            throw new IllegalArgumentException("nice try");
        }
        this.balance -= amount;
    }

}
