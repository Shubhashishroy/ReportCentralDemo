package com.project.reportcentral.controller;

import com.project.reportcentral.model.ReportCentralModel;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ReportCentralController {

    @GetMapping("/reportInfo")
    public ReportCentralModel getReportInfo(@RequestParam(value = "reportId") String reportId)
    {
        ReportCentralModel mod = new ReportCentralModel(reportId,"Interest",1);
        return mod;
    }
}
