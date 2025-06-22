package com.application.Timesheet.controller;

import com.application.Timesheet.entity.SaveTimeSheetEntity;
import com.application.Timesheet.repository.TimeSheetRepo;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import java.util.Arrays;
import java.util.List;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

class UserManagementControllerTest {

    @Mock
    private TimeSheetRepo timeSheetRepo;

    @InjectMocks
    private UserManagementController controller;

    public UserManagementControllerTest() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testSaveTimeSheetInfo() {
        SaveTimeSheetEntity entity = new SaveTimeSheetEntity();
        when(timeSheetRepo.save(entity)).thenReturn(entity);

        String result = controller.saveTimeSheetInfo(entity);

        verify(timeSheetRepo, times(1)).save(entity);
        assertEquals("Successfully saved", result);
    }

    @Test
    void testApproveTimeSheetInfo() {
        SaveTimeSheetEntity e1 = new SaveTimeSheetEntity();
        SaveTimeSheetEntity e2 = new SaveTimeSheetEntity();
        List<SaveTimeSheetEntity> list = Arrays.asList(e1, e2);

        when(timeSheetRepo.saveAll(list)).thenReturn(list);

        String result = controller.approveTimeSheetInfo(list);

        verify(timeSheetRepo).saveAll(list);
        assertEquals("Updated timesheet", result);
    }

    @Test
    void testGetTimeSheetEntries() {
        List<SaveTimeSheetEntity> expectedList = Arrays.asList(new SaveTimeSheetEntity());
        when(timeSheetRepo.findAll()).thenReturn(expectedList);

        List<SaveTimeSheetEntity> result = controller.getTimeSheetEntries();

        verify(timeSheetRepo).findAll();
        assertEquals(expectedList, result);
    }
}

