package io.youngwon.auctioncore.exception;

public class BadRequestException extends RuntimeException {

    private ErrorType errorType;

    public BadRequestException() {
        super("not implemented");
    }

    public BadRequestException(ErrorType errorType) {
        this.errorType = errorType;
    }

    public enum ErrorType {
        NotWaitProduct
    }
}
