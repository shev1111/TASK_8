package com.shev.server.exeption;

public class WrongDatePatternException extends Exception {
    public WrongDatePatternException() {
    }

    public WrongDatePatternException(String message) {
        super(message);
    }

    public WrongDatePatternException(String message, Throwable cause) {
        super(message, cause);
    }

    public WrongDatePatternException(Throwable cause) {
        super(cause);
    }

    public WrongDatePatternException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
