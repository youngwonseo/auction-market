package io.youngwon.auctionapi;

import io.youngwon.auctionapi.common.ApiUtils;
import io.youngwon.auctioncore.exception.BadRequestException;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import static io.youngwon.auctionapi.common.ApiUtils.error;

@RestControllerAdvice
public class ControllerAdvice {

    @ExceptionHandler(EntityNotFoundException.class)
    public ResponseEntity<ApiUtils.ApiResult<?>> handleEntityNotFoundException(Exception ex) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(error(ex, HttpStatus.NOT_FOUND));
    }

    @ExceptionHandler(BadRequestException.class)
    public ResponseEntity<ApiUtils.ApiResult<?>> handleBadRequestException(BadRequestException ex) {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(error(ex, HttpStatus.BAD_REQUEST));
    }
}
