package com.application.Timesheet.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.application.Timesheet.entity.SaveTimeSheetEntity;

public interface TimeSheetRepo extends JpaRepository<SaveTimeSheetEntity, String> {

}
