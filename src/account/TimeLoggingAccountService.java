package account;

import currency.Currency;
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
    public BankAccount createCurrentAccount(AccountHolder accountHolder, Currency currency) {
        IO.println("Create Bank Account started, " + now());
        BankAccount account = super.createCurrentAccount(accountHolder, currency);
        IO.println("Create Bank Account finished, " + now());
        return account;
    }

    @Override
    public BankAccount createBusinessAccount(AccountHolder accountHolder, Currency currency) {
        IO.println("Create Bank Account started, " + now());
        BankAccount account = super.createBusinessAccount(accountHolder, currency);
        IO.println("Create Bank Account finished, " + now());
        return account;
    }

    @Override
    public BankAccount createStudentAccount(AccountHolder accountHolder, String schoolName, Currency currency) {
        IO.println("Create Bank Account started, " + now());
        BankAccount account = super.createStudentAccount(accountHolder, schoolName, currency);
        IO.println("Create Bank Account finished, " + now());
        return account;
    }

    @Override
    public BankAccount createSavingsAccount(AccountHolder accountHolder, Currency currency) {
        IO.println("Create Bank Account started, " + now());
        BankAccount account = super.createSavingsAccount(accountHolder, currency);
        IO.println("Create Bank Account finished, " + now());
        return account;
    }

    private String now() {
        return LocalTime.now().format(TIME_FORMAT);
    }
}
