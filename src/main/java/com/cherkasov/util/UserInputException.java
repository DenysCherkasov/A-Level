package com.cherkasov.util;

public class UserInputException extends RuntimeException {

    public UserInputException() {
        super();
    }

    public UserInputException(String s) {
        super(s);
    }

    public UserInputException(String message, Throwable cause) {
        super(message, cause);
    }

    public UserInputException(Throwable cause) {
        super(cause);
    }

    @java.io.Serial
    private static final long serialVersionUID = -5365630128856068164L;
}
