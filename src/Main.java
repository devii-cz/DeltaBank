import account.BankAccount;
import account.CurrentAccount;
import account.StudentAccount;
import person.AccountHolder;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        AccountHolder holder = new AccountHolder("Daniel", "Bisko");

        BankAccount acc = new CurrentAccount("58958", holder);
        BankAccount studentAcc = new StudentAccount("67", holder, "DELTA");

        List<BankAccount> bankAccounts = new ArrayList<>();
        bankAccounts.add(acc);
        bankAccounts.add(studentAcc);

        for (BankAccount account: bankAccounts){

            if (account instanceof StudentAccount) {
                StudentAccount stdAccount = (StudentAccount) account;
                System.out.println("school: " + stdAccount.getSchoolName());
            }

            System.out.println("balance: " + account.getBalance());

        }


        printBalance(acc);

        acc.add(400);
        printBalance(acc);
        acc.sub(300);
        acc.sub(100);

        printBalance(acc);

    }

    private static void printBalance(BankAccount bankAccount) {
        System.out.println("balance: " + bankAccount.getBalance());
    }
}