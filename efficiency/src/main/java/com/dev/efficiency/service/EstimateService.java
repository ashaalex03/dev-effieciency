package com.dev.efficiency.service;

import com.dev.efficiency.entity.Estimate;

import com.dev.efficiency.exception.ResourceNotFoundException;

import java.util.List;

public interface EstimateService {
    List<Estimate> getAllSprintEstimate(String sprintName) throws ResourceNotFoundException;

    Estimate createEstimate(Estimate estimateEntity);

    void deleteEstimate(int jiraId) throws ResourceNotFoundException;

    Estimate UpdateEstimate(Estimate estimateEntity) throws ResourceNotFoundException;
}
