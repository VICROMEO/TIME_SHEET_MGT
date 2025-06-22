package com.application.Timesheet;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
@OpenAPIDefinition(
		info = @Info(
				title = "Timesheet API",
				version = "1.0",
				description = "API documentation for Timesheet Management"
		)
)
@SpringBootApplication
public class TimesheetMgt {

	public static void main(String[] args) {

		SpringApplication.run(TimesheetMgt.class, args);
	}
}
