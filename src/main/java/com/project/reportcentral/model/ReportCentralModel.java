package com.project.reportcentral.model;

public class ReportCentralModel {
    private String reportId;
    private String reportName;
    private int version;


    public ReportCentralModel(String reportId, String reportName, int version) {
        this.reportId = reportId;
        this.reportName = reportName;
        this.version = version;
    }

    public String getReportId() {
        return reportId;
    }

    public String getReportName() {
        return reportName;
    }

    public int getVersion() {
        return version;
    }
}
