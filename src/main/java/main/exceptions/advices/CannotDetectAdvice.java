package main.exceptions.advices;

import main.exceptions.CannotDetectException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class CannotDetectAdvice {
    @ResponseBody
    @ExceptionHandler(CannotDetectException.class)
    @ResponseStatus(HttpStatus.I_AM_A_TEAPOT)
    String notFoundHandler(CannotDetectException e){
        return e.getMessage();
    }
}
