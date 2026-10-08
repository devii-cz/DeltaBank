import account.*;
import history.TransferLoggerService;
import person.AccountHolder;
import person.AccountHolderFactory;
import transfer.DepositService;
import transfer.TransferService;

public class Main {

    public static void main(String[] args) {

        AccountHolderFactory creator = new AccountHolderFactory();
        AccountHolder holder = creator.newAccountHolder("Daniel", "Bisko");

        BankAccountFactory accountCreator = new BankAccountFactory();

        BankAccount currentAccount = accountCreator.newCurrentAccount(holder);
        BankAccount businessAccount = accountCreator.newBusinessAccount(holder);
        BankAccount studentAccount = accountCreator.newStudentAccount(holder, "DELTA");

        TransferLoggerService transferLoggerService = new TransferLoggerService();
        DepositService depositService = new DepositService(transferLoggerService);
        TransferService transferService = new TransferService(transferLoggerService);

        IO.println(currentAccount.getAccountNumber());
        depositService.deposit(currentAccount, 5000);
        depositService.deposit(businessAccount, 10000);

        printBalances(currentAccount, businessAccount, studentAccount);

        transferService.transfer(currentAccount, studentAccount, 1000);
        printBalances(currentAccount, businessAccount, studentAccount);

        transferService.transfer(businessAccount, currentAccount, 2000);
        printBalances(currentAccount, businessAccount, studentAccount);

        try {
            transferService.transfer(currentAccount, studentAccount, -500);
        } catch (IllegalArgumentException e) {
            IO.println("Zachycena chyba: " + e.getMessage());
        }

        try {
            transferService.transfer(currentAccount, currentAccount, 500);
        } catch (IllegalArgumentException e) {
            IO.println("Zachycena chyba: " + e.getMessage());
        }

        try {
            transferService.transfer(currentAccount, studentAccount, 999999);
        } catch (IllegalArgumentException e) {
            IO.println("Zachycena chyba: " + e.getMessage());
        }

        transferLoggerService.printHistory();
    }

    private static void printBalances(BankAccount current, BankAccount business, BankAccount student) {
        IO.println("Current:  " + current.getBalance() + " Kč");
        IO.println("Business: " + business.getBalance() + " Kč");
        IO.println("Student:  " + student.getBalance() + " Kč");
    }
}
