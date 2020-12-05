package com.project.reportcentral.ReportRepository;

import com.project.reportcentral.model.ReportCentralModel;
import org.springframework.jdbc.core.RowCallbackHandler;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class ReportRowMapper implements RowMapper<ReportCentralModel> {
    @Override
    public ReportCentralModel mapRow(ResultSet resultSet, int i) throws SQLException {
        ReportCentralModel rcm= new ReportCentralModel(resultSet.getString("reportId"),resultSet.getString("reportName"),resultSet.getString("reportFormat"));
        return rcm;
    }
}
