package com.project.reportcentral.ReportRepository;

import com.project.reportcentral.model.ReportCentralModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.dao.support.DataAccessUtils;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class ReportRepository {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Autowired
    private DataSource dataSource;

    Exception ex = new Exception();

    public List<ReportCentralModel> findAll()
    {
        String query = "select * from reportInfo";
        return jdbcTemplate.query(query, new ReportRowMapper());
    }

    public ReportCentralModel findById(String reportId)
    {
        NamedParameterJdbcTemplate namedParameterJdbcTemplate = new NamedParameterJdbcTemplate(dataSource);
        SqlParameterSource namedparameters = new MapSqlParameterSource().addValue("reportId",reportId);
        String query = "select * from reportInfo where reportId = :reportId ";
        List<ReportCentralModel> result;
        result = namedParameterJdbcTemplate.query(query,namedparameters,new ReportRowMapper());
        ReportCentralModel rcm = DataAccessUtils.singleResult(result);
        return rcm;
    }

    public int addReportInfo(ReportCentralModel reportCentralModel,String uuid)
    {
        Map rMap = new HashMap();
        rMap.put("reportId",reportCentralModel.getReportId());
        rMap.put("reportName",reportCentralModel.getReportName());
        rMap.put("reportType",reportCentralModel.getReportType());
        rMap.put("reportFormat",reportCentralModel.getReportFormat());
        rMap.put("creationDate",reportCentralModel.getCreationTime());
        rMap.put("reportUuid",uuid);
        NamedParameterJdbcTemplate namedParameterJdbcTemplate = new NamedParameterJdbcTemplate(dataSource);
        String query = "INSERT into reportInfo VALUES(:reportId,:reportName,:reportType,:reportFormat,:creationDate,:reportUuid)";
        try {
            return namedParameterJdbcTemplate.update(query, rMap);
        }catch(DataAccessException e)
        {
            return 0;
        }
        //jdbcTemplate.update(query,reportCentralModel.getReportId(),reportCentralModel.getReportName(),reportCentralModel.getReportType(),reportCentralModel.getReportFormat(),reportCentralModel.getCreationTime());
    }
}