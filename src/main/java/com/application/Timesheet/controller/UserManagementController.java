package com.application.Timesheet.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.application.Timesheet.entity.SaveTimeSheetEntity;
import com.application.Timesheet.repository.TimeSheetRepo;


@RestController
@RequestMapping("/timesheet")
public class UserManagementController {

	@Autowired
	private TimeSheetRepo timeSheetRepo;

	@PostMapping("/submitTimeSheetInfo")
	public String saveTimeSheetInfo(@RequestBody SaveTimeSheetEntity timesheet) {
		timeSheetRepo.save(timesheet);
		return "Successfully saved";

	}

	@PostMapping("/approve")
	public String approveTimeSheetInfo(@RequestBody List<SaveTimeSheetEntity> timesheet) {
		timeSheetRepo.saveAll(timesheet);
		return "Updated timesheet";

	}

	@GetMapping("/getTimeSheetInfo")
	public List<SaveTimeSheetEntity> getTimeSheetEntries() {
		return timeSheetRepo.findAll();
	}

}
