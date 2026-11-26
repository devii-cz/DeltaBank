package account;

import currency.Currency;
import notifier.ConsoleNotifierService;
import notifier.NotifierService;
import person.AccountHolder;
import java.util.UUID;

public abstract class BankAccount {

    private String uuid;
    private AccountHolder accountHolder;
    private String accountNumber;
    private double balance;
    private Currency currency;

    private NotifierService notifier = new ConsoleNotifierService();

    public BankAccount(String accountNumber, AccountHolder accountHolder, Currency currency) {
        this.uuid = UUID.randomUUID().toString();
        this.balance = 0;
        this.accountNumber = accountNumber;
        this.accountHolder = accountHolder;
        this.currency = currency;
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

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public Currency getCurrency() {
        return currency;
    }

    public void add(double amount){
        if (amount<0) {
            throw new IllegalArgumentException("nice try");
        }
        this.balance += amount;
        notifier.notify("money added");
    }

    public void sub(double amount){
        if (amount<0) {
            throw new IllegalArgumentException("nice try");
        }
        this.balance -= amount;
    }
}
