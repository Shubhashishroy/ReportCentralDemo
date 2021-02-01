create table reportInfo(
    reportId varchar(50) NOT NULL,
    reportName varchar(100) NOT NULL,
    reportType varchar(20) NOT NULL,
    reportFormat varchar(50) NOT NULL,
    creationDate TIMESTAMP NOT NULL,
    reportUuid varchar(100) NULL,
    PRIMARY KEY(reportId)
);