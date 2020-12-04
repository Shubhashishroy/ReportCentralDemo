package com.project.reportcentral.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication(exclude = DataSourceAutoConfiguration.class)
@ComponentScan(basePackages = "com.project.reportcentral.controller")
public class ReportCentralApplication {

	public static void main(String[] args) {
		SpringApplication.run(ReportCentralApplication.class, args);
	}

}
