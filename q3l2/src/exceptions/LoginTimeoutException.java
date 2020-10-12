package exceptions;

public class LoginTimeoutException extends Exception {
    public LoginTimeoutException() {
        super();
    }

    public LoginTimeoutException(String message) {
        super(message);
    }

    public LoginTimeoutException(String message, Throwable cause) {
        super(message, cause);
    }

    public LoginTimeoutException(Throwable cause) {
        super(cause);
    }

    protected LoginTimeoutException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
