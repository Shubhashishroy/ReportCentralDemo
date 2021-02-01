package com.project.reportcentral.ReportException;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.CONFLICT)
public class ReportNotCreatedException extends RuntimeException{
        public ReportNotCreatedException(String errorMessage)
        {
            super(errorMessage);
        }
}
