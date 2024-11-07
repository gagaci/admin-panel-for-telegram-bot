package com.company.adminpaneltelegrambot.exception;
import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
public class ExceptionService extends RuntimeException {

    private final HttpStatus httpStatus;

    public ExceptionService(final String message) {
        super(message);
        this.httpStatus = HttpStatus.INTERNAL_SERVER_ERROR;
    }

    public ExceptionService(String message, HttpStatus httpStatus) {
        super(message);
        this.httpStatus = httpStatus;


    }
}
