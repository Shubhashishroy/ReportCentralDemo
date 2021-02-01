package com.project.reportcentral.ReportException;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class ReportExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(ReportNotFoundException.class)
    public ResponseEntity<?> handleReportNotFoundException(ReportNotFoundException rex)
    {
        String error = rex.getLocalizedMessage();
        return new ResponseEntity<>(error, HttpStatus.NOT_FOUND);
    }
    @ExceptionHandler(ReportNotCreatedException.class)
    public ResponseEntity<?> handleReportNotCreatedException(ReportNotCreatedException rex)
    {
        String error = rex.getLocalizedMessage();
        return new ResponseEntity<>(error, HttpStatus.CONFLICT);
    }
}