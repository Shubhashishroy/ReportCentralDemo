package com.project.reportcentral.model;

import java.sql.Timestamp;

public class ReportCentralModel {
    private String reportId;
    private String reportName;
    private String reportType;
    private String reportFormat;
    private Timestamp creationTime;
    private String reportUuid;

    public ReportCentralModel(){};

    public String getReportId() { return reportId; }

    public String getReportName() {
        return reportName;
    }

    public String getReportType() {
        return reportType;
    }

    public String getReportFormat() {
        return reportFormat;
    }

    public Timestamp getCreationTime() {
        return creationTime;
    }

    public String getReportUuid() {
        return reportUuid;
    }

    public ReportCentralModel(String reportId, String reportName, String reportType, String reportFormat, Timestamp creationTime, String reportUuid) {
        this.reportId = reportId;
        this.reportName = reportName;
        this.reportType = reportType;
        this.reportFormat = reportFormat;
        this.creationTime = creationTime;
        this.reportUuid = reportUuid;
    }
}