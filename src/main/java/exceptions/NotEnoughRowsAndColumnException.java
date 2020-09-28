package exceptions;

public class NotEnoughRowsAndColumnException extends RuntimeException {
    public NotEnoughRowsAndColumnException(String message) {
        super(message);
    }
}
