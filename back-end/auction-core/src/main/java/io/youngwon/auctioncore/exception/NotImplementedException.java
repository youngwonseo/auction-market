package io.youngwon.auctioncore.exception;

public class NotImplementedException extends RuntimeException {

    public NotImplementedException() {
        super("not implemented");
    }

    public NotImplementedException(String message) {
        super(message);
    }
}
