package account;

import person.AccountHolder;

public class LoggingAccountService extends AccountServiceDecorator {

    public LoggingAccountService(AccountService accountService) {
        super(accountService);
    }

    @Override
    public BankAccount createCurrentAccount(AccountHolder accountHolder) {
        IO.println("Create Bank Account started");
        BankAccount account = super.createCurrentAccount(accountHolder);
        IO.println("Create Bank Account finished");
        return account;
    }

    @Override
    public BankAccount createBusinessAccount(AccountHolder accountHolder) {
        IO.println("Create Bank Account started");
        BankAccount account = super.createBusinessAccount(accountHolder);
        IO.println("Create Bank Account finished");
        return account;
    }

    @Override
    public BankAccount createStudentAccount(AccountHolder accountHolder, String schoolName) {
        IO.println("Create Bank Account started");
        BankAccount account = super.createStudentAccount(accountHolder, schoolName);
        IO.println("Create Bank Account finished");
        return account;
    }

    @Override
    public BankAccount createSavingsAccount(AccountHolder accountHolder) {
        IO.println("Create Bank Account started");
        BankAccount account = super.createSavingsAccount(accountHolder);
        IO.println("Create Bank Account finished");
        return account;
    }
}
