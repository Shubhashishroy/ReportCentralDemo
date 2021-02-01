package com.project.reportcentral.Service;

import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.project.reportcentral.ReportRepository.ReportRepository;
import com.project.reportcentral.model.ReportCentralModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class ReportCentralService
{
    @Autowired
    private ReportRepository reportRepository;

    RestTemplate restTemplate = new RestTemplate();

    public int addReportInfo(ReportCentralModel reportCentralModel){
        String Jsonuuid = restTemplate.getForObject("https://httpbin.org/uuid", String.class);

          JsonObject jsonObject = new JsonParser().parse(Jsonuuid).getAsJsonObject();
          String uuid = jsonObject.get("uuid").getAsString();

        return reportRepository.addReportInfo(reportCentralModel,uuid);
    }
}