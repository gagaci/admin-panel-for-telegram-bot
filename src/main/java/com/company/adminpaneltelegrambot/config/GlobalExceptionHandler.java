package com.company.adminpaneltelegrambot.config;

import com.company.adminpaneltelegrambot.base.Failure;
import com.company.adminpaneltelegrambot.base.Result;
import com.company.adminpaneltelegrambot.exception.ExceptionService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;


@Slf4j
@RestControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler({MethodArgumentNotValidException.class})
    public ResponseEntity<Result<Failure>> methodArgumentNotValidException(
            MethodArgumentNotValidException ex) {
        FieldError firstError = ex.getBindingResult().getFieldErrors().get(0);
        Failure failure = new Failure(firstError.getDefaultMessage(), firstError.getField());

        return ResponseEntity
                .badRequest()
                .body(new Result<>(failure));
    }

    @ExceptionHandler({Exception.class, RuntimeException.class})
    public ResponseEntity<Result<Failure>> handleException(Exception e) {
        log.error("Exception: ", e);
        Failure failure = new Failure(e.getMessage());
        return ResponseEntity
                .internalServerError()
                .body(new Result<>(failure));
    }

    @ExceptionHandler({ExceptionService.class})
    public ResponseEntity<Result<Failure>> handleException(ExceptionService e) {
        if (e.getHttpStatus().is5xxServerError()) {
            log.error("ServiceException: ", e);
        }
        Failure failure = new Failure(e.getMessage());
        return ResponseEntity
                .status(e.getHttpStatus())
                .body(new Result<>(failure));
    }
}
