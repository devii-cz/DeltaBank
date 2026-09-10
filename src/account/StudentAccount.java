package account;

import person.AccountHolder;

public class StudentAccount extends BankAccount{

    private String schoolName;

    public String getSchoolName() {
        return schoolName;
    }

    public StudentAccount(String accountNumber, AccountHolder accountHolder, String schoolName) {
        super(accountNumber, accountHolder);

        this.schoolName = schoolName;
    }

    @Override
    public void add(double amount) {
        double bonus = amount*0.05;
        super.add(bonus);
        super.add(amount);
    }

    @Override
    public void sub(double amount) {
        double balance = getBalance();
        if (balance-amount<-5000){
            throw new IllegalArgumentException("nemuzes byt mene nez 5000 v minusu");
        }
        super.sub(amount);
    }
}
