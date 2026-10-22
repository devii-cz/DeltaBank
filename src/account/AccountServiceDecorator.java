package account;

import person.AccountHolder;

import java.util.List;

public abstract class AccountServiceDecorator implements AccountService {

    protected final AccountService accountService;

    protected AccountServiceDecorator(AccountService accountService) {
        this.accountService = accountService;
    }

    @Override
    public BankAccount createCurrentAccount(AccountHolder accountHolder) {
        return accountService.createCurrentAccount(accountHolder);
    }

    @Override
    public BankAccount createBusinessAccount(AccountHolder accountHolder) {
        return accountService.createBusinessAccount(accountHolder);
    }

    @Override
    public BankAccount createStudentAccount(AccountHolder accountHolder, String schoolName) {
        return accountService.createStudentAccount(accountHolder, schoolName);
    }

    @Override
    public BankAccount createSavingsAccount(AccountHolder accountHolder) {
        return accountService.createSavingsAccount(accountHolder);
    }

    @Override
    public List<BankAccount> getBankAccounts() {
        return accountService.getBankAccounts();
    }
}
