package main.exceptions.advices;

import main.exceptions.NoServiceException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class NoServiceAdvice {
    @ResponseBody
    @ExceptionHandler(NoServiceException.class)
    @ResponseStatus(HttpStatus.SERVICE_UNAVAILABLE)
    String notFoundHandler(NoServiceException e){
        return e.getMessage();
    }
}
