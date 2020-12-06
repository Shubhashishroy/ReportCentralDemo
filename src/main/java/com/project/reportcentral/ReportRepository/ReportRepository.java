package com.project.reportcentral.ReportRepository;

import com.project.reportcentral.model.ReportCentralModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public class ReportRepository {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public List<ReportCentralModel> findAll()
    {
        String query = "select * from reportInfo";
        return jdbcTemplate.query(query, new ReportRowMapper());
    }

    public List<ReportCentralModel> findById(String reportId)
    {
        String query = "select * from reportInfo where reportId = " + "'" + reportId + "'" ;
        return jdbcTemplate.query(query, new ReportRowMapper());
    }

    public void addReportInfo(ReportCentralModel reportCentralModel)
    {
        String query = "INSERT into reportInfo VALUES(?,?,?,?,?)";
        jdbcTemplate.update(query,reportCentralModel.getReportId(),reportCentralModel.getReportName(),reportCentralModel.getReportType(),reportCentralModel.getReportFormat(),reportCentralModel.getCreationTime());
    }
}