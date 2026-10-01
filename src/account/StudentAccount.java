package account;

import person.AccountHolder;

public class StudentAccount extends BankAccount{

    private String schoolName;

    public StudentAccount(
            String accountNumber,
            AccountHolder accountHolder,
            String schoolName
    ) {
        super(accountNumber, accountHolder);

        this.schoolName = schoolName;
    }

    public String getSchoolName() {
        return schoolName;
    }
}
