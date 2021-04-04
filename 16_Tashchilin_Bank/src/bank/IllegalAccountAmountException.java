package bank;

public class IllegalAccountAmountException extends RuntimeException {
    public IllegalAccountAmountException(String message) {
        super(message);
    }
}
