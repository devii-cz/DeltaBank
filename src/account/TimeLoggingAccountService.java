package account;

import person.AccountHolder;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public class TimeLoggingAccountService extends AccountServiceDecorator {

    private static final DateTimeFormatter TIME_FORMAT =
            DateTimeFormatter.ofPattern("HH:mm:ss.SSSSSS");

    public TimeLoggingAccountService(AccountService accountService) {
        super(accountService);
    }

    @Override
    public BankAccount createCurrentAccount(AccountHolder accountHolder) {
        IO.println("Create Bank Account started, " + now());
        BankAccount account = super.createCurrentAccount(accountHolder);
        IO.println("Create Bank Account finished, " + now());
        return account;
    }

    @Override
    public BankAccount createBusinessAccount(AccountHolder accountHolder) {
        IO.println("Create Bank Account started, " + now());
        BankAccount account = super.createBusinessAccount(accountHolder);
        IO.println("Create Bank Account finished, " + now());
        return account;
    }

    @Override
    public BankAccount createStudentAccount(AccountHolder accountHolder, String schoolName) {
        IO.println("Create Bank Account started, " + now());
        BankAccount account = super.createStudentAccount(accountHolder, schoolName);
        IO.println("Create Bank Account finished, " + now());
        return account;
    }

    @Override
    public BankAccount createSavingsAccount(AccountHolder accountHolder) {
        IO.println("Create Bank Account started, " + now());
        BankAccount account = super.createSavingsAccount(accountHolder);
        IO.println("Create Bank Account finished, " + now());
        return account;
    }

    private String now() {
        return LocalTime.now().format(TIME_FORMAT);
    }
}
