package account;

import person.AccountHolder;

public class BankAccountFactory {
    public CurrentAccount newCurrentAccount (AccountHolder accountHolder){
        String accountNumber = ANG.generate();

        return new CurrentAccount(accountNumber, accountHolder);
    }

    public BusinessAccount newBusinessAccount (AccountHolder accountHolder){
        String accountNumber = ANG.generate();

        return new BusinessAccount(accountNumber, accountHolder);
    }

    public StudentAccount newStudentAccount (AccountHolder accountHolder, String schoolName){
        String accountNumber = ANG.generate();

        return new StudentAccount(accountNumber, accountHolder, schoolName);
    }

    public SavingsAccount newSavingsAccount (AccountHolder accountHolder){
        String accountNumber = ANG.generate();

        return new SavingsAccount(accountNumber, accountHolder);
    }
;}
