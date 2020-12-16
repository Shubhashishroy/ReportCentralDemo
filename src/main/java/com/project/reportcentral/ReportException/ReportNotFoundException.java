package com.project.reportcentral.ReportException;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class ReportNotFoundException extends RuntimeException {
    public ReportNotFoundException(String errorMessage)
    {
        super(errorMessage);
    }
}
