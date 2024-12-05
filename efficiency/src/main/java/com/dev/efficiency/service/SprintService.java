package com.dev.efficiency.service;

import com.dev.efficiency.entity.Sprint;
import com.dev.efficiency.exception.ResourceNotFoundException;

import java.util.List;

public interface SprintService {
    Sprint createSprint(Sprint sprintEntity) throws ResourceNotFoundException;

    List<Sprint> getSprintDetails(String projectCode) throws ResourceNotFoundException;

    void deleteSprint(long sprintId,String reason) throws ResourceNotFoundException;

    Sprint updateSprint(Sprint sprintEntity) throws ResourceNotFoundException;
}
