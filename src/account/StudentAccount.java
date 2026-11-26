package account;

import currency.Currency;
import person.AccountHolder;

public class StudentAccount extends BankAccount{

    private String schoolName;

    public StudentAccount(
            String accountNumber,
            AccountHolder accountHolder,
            String schoolName,
            Currency currency
    ) {
        super(accountNumber, accountHolder, currency);

        this.schoolName = schoolName;
    }

    public String getSchoolName() {
        return schoolName;
    }
}
