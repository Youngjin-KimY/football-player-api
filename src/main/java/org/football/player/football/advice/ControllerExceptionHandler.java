package org.football.player.football.advice;

import lombok.extern.slf4j.Slf4j;
import org.football.player.football.exception.BussinessException;
import org.football.player.football.exception.InValidParameterException;
import org.football.player.football.exception.NoResourceException;
import org.football.player.football.model.ErrorMessage;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@Slf4j
@RestControllerAdvice
public class ControllerExceptionHandler {
    @ResponseStatus(HttpStatus.CONFLICT)
    @ExceptionHandler(BussinessException.class)
    public ErrorMessage HandleBussinessException(BussinessException ex){
        log.error(ex.getMessage(),ex);
        return new ErrorMessage("[BussinessException] "+ex.getMessage());
    }

    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ExceptionHandler(NoResourceException.class)
    public ErrorMessage HandleNoResourceException(NoResourceException ex){
        log.error(ex.getMessage(),ex);
        return new ErrorMessage("[NoResourceException] "+ex.getMessage());
    }

    @ResponseStatus(HttpStatus.NOT_ACCEPTABLE)
    @ExceptionHandler(InValidParameterException.class)
    public ErrorMessage HandleInValidParameterException(InValidParameterException ex){
        log.error(ex.getMessage(),ex);
        return new ErrorMessage("[InValidParameterException] "+ex.getMessage());
    }
}
