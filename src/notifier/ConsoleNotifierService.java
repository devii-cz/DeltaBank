package notifier;

public class ConsoleNotifierService implements NotifierService{
    public void notify(String message) {
        IO.println("CONSOLE: " + message);
    }
}
