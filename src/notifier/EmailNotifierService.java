package notifier;

public class EmailNotifierService implements NotifierService{
    public void notify(String message) {
        IO.println("EMAIL: " + message);
    }
}
