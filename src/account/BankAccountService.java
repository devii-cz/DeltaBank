package account;

import currency.Currency;
import person.AccountHolder;

import java.util.ArrayList;
import java.util.List;

public class BankAccountService implements AccountService {

    private final BankAccountFactory bankAccountFactory;
    private final List<BankAccount> bankAccounts = new ArrayList<>();

    public BankAccountService(BankAccountFactory bankAccountFactory) {
        this.bankAccountFactory = bankAccountFactory;
    }

    @Override
    public BankAccount createCurrentAccount(AccountHolder accountHolder, Currency currency) {
        BankAccount account = bankAccountFactory.newCurrentAccount(accountHolder, currency);
        bankAccounts.add(account);
        return account;
    }

    @Override
    public BankAccount createBusinessAccount(AccountHolder accountHolder, Currency currency) {
        BankAccount account = bankAccountFactory.newBusinessAccount(accountHolder, currency);
        bankAccounts.add(account);
        return account;
    }

    @Override
    public BankAccount createStudentAccount(AccountHolder accountHolder, String schoolName, Currency currency) {
        BankAccount account = bankAccountFactory.newStudentAccount(accountHolder, schoolName, currency);
        bankAccounts.add(account);
        return account;
    }

    @Override
    public BankAccount createSavingsAccount(AccountHolder accountHolder, Currency currency) {
        BankAccount account = bankAccountFactory.newSavingsAccount(accountHolder, currency);
        bankAccounts.add(account);
        return account;
    }

    @Override
    public List<BankAccount> getBankAccounts() {
        return bankAccounts;
    }
}
