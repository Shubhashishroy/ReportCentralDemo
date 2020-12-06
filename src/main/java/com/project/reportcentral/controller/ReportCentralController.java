package com.project.reportcentral.controller;

import com.project.reportcentral.ReportRepository.ReportRepository;
import com.project.reportcentral.model.ReportCentralModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

//import java.sql.Date;
import java.sql.Timestamp;
import java.time.Instant;
import java.util.List;
import java.util.Date;

@RestController
public class ReportCentralController {

    @Autowired
    private ReportRepository reportRepository;

    @GetMapping("/reportInfo")
    public ReportCentralModel getReportInfo(@RequestParam(value = "reportId") String reportId)
    {
        ReportCentralModel mod = new ReportCentralModel(reportId,"Interest","WIRE","PDF", Timestamp.from(Instant.now()));
//new Timestamp(new Date().getTime()));
        return mod;
    }

    @GetMapping("/getAll")
    public List<ReportCentralModel> getAllReportInfo()
    {
        List<ReportCentralModel> ls = reportRepository.findAll();
        return ls;
    }

    @GetMapping("/getById")
    public List<ReportCentralModel> getReportInfoById(@RequestParam(value = "reportId") String reportId)
    {
        List<ReportCentralModel> ls = reportRepository.findById(reportId);
        return ls;
    }

    @PostMapping("/addInfo")
    public void addReportInfo(@RequestBody ReportCentralModel reportCentralModel)
    {
        reportRepository.addReportInfo(reportCentralModel);
    }
}
