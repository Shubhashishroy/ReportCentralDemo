package com.project.reportcentral.controller;

import com.project.reportcentral.ReportException.ReportNotCreatedException;
import com.project.reportcentral.ReportException.ReportNotFoundException;
import com.project.reportcentral.ReportRepository.ReportRepository;
import com.project.reportcentral.Service.ReportCentralService;
import com.project.reportcentral.model.ReportCentralModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.sql.Timestamp;
import java.time.Instant;
import java.util.LinkedList;
import java.util.List;

@RestController
public class ReportCentralController {

    @Autowired
    private ReportRepository reportRepository;

    @Autowired
    private ReportCentralService reportCentralService;

    @GetMapping("/reportInfo")
    public ReportCentralModel getReportInfo(@RequestParam(value = "reportId") String reportId)
    {
        ReportCentralModel mod =  new ReportCentralModel(reportId,"Interest","WIRE","PDF", Timestamp.from(Instant.now()),"DEFAULT UUID"); //new Timestamp(new Date().getTime()));
        return mod;
    }
    /* This method returns all the reports and their information stored in database */
    @GetMapping("/getAll")
    public ResponseEntity<?> getAllReportInfo()
    {
        List<ReportCentralModel> ls = reportRepository.findAll();
        if(!ls.isEmpty())
            return new ResponseEntity<>(ls, HttpStatus.OK);
        else
            return new ResponseEntity<>("No Report exists",HttpStatus.NOT_FOUND);
    }
    /*
     This method returns report Info for a particular report.
     This method is written using ResponseEntity and returns a list and the HTTP status
    */
    @GetMapping("/getById")
    public ResponseEntity<?> getReportInfoById(@RequestParam(value = "reportId") String reportId)
    {
        List<ReportCentralModel> ls = new LinkedList<>();
        ls.add(reportRepository.findById(reportId));
        if(!ls.isEmpty())
            return new ResponseEntity<>(ls, HttpStatus.OK);
        else
            return new ResponseEntity<>(String.format("Information of %s report does not exist",reportId),HttpStatus.NOT_FOUND);
    }
    /*
     This method returns report Info for a particular report. The method involves CustomExceptionHandling concept,
      @ControllerAdvice annotation.
    */
    @GetMapping("/getByReportId")
    public ReportCentralModel getReportById(@RequestParam(value = "reportId") String reportId) {
        ReportCentralModel rcm = reportRepository.findById(reportId);
        if(rcm != null)
            return rcm;
        else
           // System.out.print("Report does not exist");
            throw new ReportNotFoundException(String.format("Report %s does not exist",reportId));
    }

//    @PostMapping("/createReport")
//    public ResponseEntity<?> addReportInfo(@RequestBody ReportCentralModel reportCentralModel)
//    {
//        int c = reportRepository.addReportInfo(reportCentralModel);
//        if(c >= 1)
//            return new ResponseEntity<>("New report was created successfully.",HttpStatus.CREATED);
//        else
//            throw new ReportNotCreatedException(String.format("Report %s already exists",reportCentralModel.getReportId()));
//    }

    @PostMapping("/createReport")
    public ResponseEntity<?> addReportInfoUuid(@RequestBody ReportCentralModel reportCentralModel) {
        int c = reportCentralService.addReportInfo(reportCentralModel);
        if (c >= 1)
            return new ResponseEntity<>("New report was created successfully.", HttpStatus.CREATED);
        else
            throw new ReportNotCreatedException(String.format("Report %s already exists", reportCentralModel.getReportId()));
    }
}