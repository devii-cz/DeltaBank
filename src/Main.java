import account.*;
import account.serialization.BankAccountGsonSerializer;
import account.serialization.BankAccountSerializer;
import account.serialization.BankAccountXmlSerializer;
import history.TransferLoggerService;
import person.AccountHolder;
import person.AccountHolderFactory;
import transfer.DepositService;
import transfer.TransferService;

public class Main {

    public static void main(String[] args) {

        AccountHolderFactory creator = new AccountHolderFactory();
        AccountHolder holder = creator.newAccountHolder("Daniel", "Bisko");

        AccountService original = new BankAccountService();

        IO.println("ORIGINAL");
        IO.println("=========");
        BankAccount currentAccount = original.createCurrentAccount(holder);

        IO.println("WITH LOGGER");
        AccountService withLogger = new LoggingAccountService(original);
        withLogger.createBusinessAccount(holder);
        IO.println("========");

        IO.println("WITH TIME LOGGER");
        AccountService withTimeLogger = new TimeLoggingAccountService(original);
        withTimeLogger.createSavingsAccount(holder);
        IO.println("========");

        IO.println("WITH LOGGER AND TIME LOGGER");
        AccountService withLoggerAndTimeLogger =
                new TimeLoggingAccountService(new LoggingAccountService(original));
        BankAccount studentAccount = withLoggerAndTimeLogger.createStudentAccount(holder, "DELTA");
        IO.println("========");

        BankAccount businessAccount = original.getBankAccounts().get(1);

        BankAccountSerializer bankAccountJsonSerializer = new BankAccountGsonSerializer();
        BankAccountSerializer bankAccountXmlSerializer = new BankAccountXmlSerializer();

        IO.println(bankAccountXmlSerializer.serialize(currentAccount));
        IO.println(bankAccountXmlSerializer.serializeAll(original.getBankAccounts()));

        IO.println(bankAccountJsonSerializer.serialize(currentAccount));
        IO.println(bankAccountJsonSerializer.serializeAll(original.getBankAccounts()));

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
