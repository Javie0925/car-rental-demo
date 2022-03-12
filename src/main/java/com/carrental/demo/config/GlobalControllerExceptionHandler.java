package com.carrental.demo.config;

import com.carrental.demo.vo.Result;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.validation.ConstraintViolationException;

/**
 * GlobalControllerExceptionHandler
 */
@RestControllerAdvice
public class GlobalControllerExceptionHandler {

    @ExceptionHandler
    public Result constraintViolationException(ConstraintViolationException ex) {
        return Result.fail(500, ex.toString());
    }
}
