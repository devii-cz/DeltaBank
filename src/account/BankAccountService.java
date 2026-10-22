package account;

import person.AccountHolder;

import java.util.ArrayList;
import java.util.List;

public class BankAccountService implements AccountService {

    private final BankAccountFactory bankAccountFactory = new BankAccountFactory();
    private final List<BankAccount> bankAccounts = new ArrayList<>();

    @Override
    public BankAccount createCurrentAccount(AccountHolder accountHolder) {
        BankAccount account = bankAccountFactory.newCurrentAccount(accountHolder);
        bankAccounts.add(account);
        return account;
    }

    @Override
    public BankAccount createBusinessAccount(AccountHolder accountHolder) {
        BankAccount account = bankAccountFactory.newBusinessAccount(accountHolder);
        bankAccounts.add(account);
        return account;
    }

    @Override
    public BankAccount createStudentAccount(AccountHolder accountHolder, String schoolName) {
        BankAccount account = bankAccountFactory.newStudentAccount(accountHolder, schoolName);
        bankAccounts.add(account);
        return account;
    }

    @Override
    public BankAccount createSavingsAccount(AccountHolder accountHolder) {
        BankAccount account = bankAccountFactory.newSavingsAccount(accountHolder);
        bankAccounts.add(account);
        return account;
    }

    @Override
    public List<BankAccount> getBankAccounts() {
        return bankAccounts;
    }
}
