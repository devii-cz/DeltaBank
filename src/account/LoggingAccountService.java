package account;

import currency.Currency;
import person.AccountHolder;

public class LoggingAccountService extends AccountServiceDecorator {

    public LoggingAccountService(AccountService accountService) {
        super(accountService);
    }

    @Override
    public BankAccount createCurrentAccount(AccountHolder accountHolder, Currency currency) {
        IO.println("Create Bank Account started");
        BankAccount account = super.createCurrentAccount(accountHolder, currency);
        IO.println("Create Bank Account finished");
        return account;
    }

    @Override
    public BankAccount createBusinessAccount(AccountHolder accountHolder, Currency currency) {
        IO.println("Create Bank Account started");
        BankAccount account = super.createBusinessAccount(accountHolder, currency);
        IO.println("Create Bank Account finished");
        return account;
    }

    @Override
    public BankAccount createStudentAccount(AccountHolder accountHolder, String schoolName, Currency currency) {
        IO.println("Create Bank Account started");
        BankAccount account = super.createStudentAccount(accountHolder, schoolName, currency);
        IO.println("Create Bank Account finished");
        return account;
    }

    @Override
    public BankAccount createSavingsAccount(AccountHolder accountHolder, Currency currency) {
        IO.println("Create Bank Account started");
        BankAccount account = super.createSavingsAccount(accountHolder, currency);
        IO.println("Create Bank Account finished");
        return account;
    }
}
