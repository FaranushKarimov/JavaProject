package Exception;

public class IntervalException extends Exception {
    private int number;
    public int getNumber() {
        return number;
    }
    public IntervalException(String message,int n) {
        super(message);
        number = n;
    }
}
