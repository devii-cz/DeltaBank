package account;

import currency.Currency;
import person.AccountHolder;

public class BankAccountFactory {

    public CurrentAccount newCurrentAccount(AccountHolder accountHolder, Currency currency) {
        String accountNumber = ANG.generate();
        return new CurrentAccount(accountNumber, accountHolder, currency);
    }

    public BusinessAccount newBusinessAccount(AccountHolder accountHolder, Currency currency) {
        String accountNumber = ANG.generate();
        return new BusinessAccount(accountNumber, accountHolder, currency);
    }

    public StudentAccount newStudentAccount(AccountHolder accountHolder, String schoolName, Currency currency) {
        String accountNumber = ANG.generate();
        return new StudentAccount(accountNumber, accountHolder, schoolName, currency);
    }

    public SavingsAccount newSavingsAccount(AccountHolder accountHolder, Currency currency) {
        String accountNumber = ANG.generate();
        return new SavingsAccount(accountNumber, accountHolder, currency);
    }
}
