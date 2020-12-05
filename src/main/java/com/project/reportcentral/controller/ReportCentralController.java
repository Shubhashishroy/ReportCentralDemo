package com.project.reportcentral.controller;

import com.project.reportcentral.ReportRepository.ReportRepository;
import com.project.reportcentral.model.ReportCentralModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ReportCentralController {

    @Autowired
    private ReportRepository reportRepository;

    @GetMapping("/reportInfo")
    public ReportCentralModel getReportInfo(@RequestParam(value = "reportId") String reportId)
    {
        ReportCentralModel mod = new ReportCentralModel(reportId,"Interest","1");
        return mod;
    }

    @GetMapping("/getAll")
    public List<ReportCentralModel> getAllReportInfo()
    {
        List<ReportCentralModel> ls = reportRepository.findAll();
        return ls;
    }
}
