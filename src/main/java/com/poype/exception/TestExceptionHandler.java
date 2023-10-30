package com.poype.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class TestExceptionHandler {

    @ResponseBody
    @ExceptionHandler({ArithmeticException.class})
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)  // 设置http code
    public String handleArithmeticException() {
        System.out.println("handleArithmeticException is invoked");
        return "Exception is handled";
    }
}
