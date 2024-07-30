package io.youngwon.app.exception;

public class NotImplementedException extends RuntimeException {

    public NotImplementedException() {
        super("not implemented");
    }

    public NotImplementedException(String message) {
        super(message);
    }
}
