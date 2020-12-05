package com.project.reportcentral.model;

public class ReportCentralModel {
    private String reportId;
    private String reportName;
    private String version;

    public ReportCentralModel(){};

    public ReportCentralModel(String reportId, String reportName, String version) {
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

    public String getVersion() {
        return version;
    }
}
