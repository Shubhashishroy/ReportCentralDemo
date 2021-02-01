package com.project.reportcentral.demo;

import com.project.reportcentral.ReportRepository.ReportRepository;
import com.project.reportcentral.controller.ReportCentralController;
import com.project.reportcentral.model.ReportCentralModel;
import org.hibernate.query.criteria.internal.expression.function.CurrentDateFunction;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.yaml.snakeyaml.representer.Represent;

import java.sql.Timestamp;
import java.time.Instant;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

public class ReportCentralControllerTest {
    @InjectMocks
    ReportCentralController reportCentralController;

    @Mock
    ReportRepository reportRepository;

    ReportCentralModel rcm = new ReportCentralModel("IN150MM","Interest Reporting","INTEREST","FIX",Timestamp.from(Instant.now()),"");
    ReportCentralModel rcm1 = new ReportCentralModel("RTM902B","Margin Reporting","MARGINS","PDF",Timestamp.from(Instant.now()),"");

    @Test
    public void testgetReportInfo(){
        //ReportCentralModel rcm = reportCentralController.getReportInfo("IN150MM");
        System.out.println(rcm.getReportId());
        //assertEquals("IN150MM",reportCentralController.getReportInfo(rcm.getReportId()).getReportId());
    }
}
