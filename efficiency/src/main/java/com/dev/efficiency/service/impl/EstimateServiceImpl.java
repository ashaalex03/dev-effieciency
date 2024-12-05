package com.dev.efficiency.service.impl;

import com.dev.efficiency.entity.Estimate;
import com.dev.efficiency.exception.ResourceNotFoundException;
import com.dev.efficiency.repository.EstimateRepository;
import com.dev.efficiency.service.EstimateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class EstimateServiceImpl implements EstimateService {

    @Autowired
    private EstimateRepository estimateRepository;

    @Override
    public Estimate createEstimate(Estimate estimateEntity) {

        return estimateRepository.saveAndFlush(estimateEntity);
    }


    @Override
    public List<Estimate> getAllSprintEstimate(String sprintName) throws ResourceNotFoundException {
        List<Estimate> sprintEntities = estimateRepository.findAllBySprintNameAndStatus(sprintName,"active");

        if (sprintEntities.isEmpty()) {
            throw new ResourceNotFoundException("Sprint not found for this Jira ID :: " + sprintName);
        }
        return sprintEntities;
    }

    @Override
    public Estimate UpdateEstimate(Estimate estimateEntity) throws ResourceNotFoundException {
        Estimate existingEstimateRecord = estimateRepository.findById(estimateEntity.getSprintId())
                .orElseThrow(() -> new ResourceNotFoundException("Estimate not found for this id :: " + estimateEntity.getSprintId()));

        existingEstimateRecord.setSprintName(estimateEntity.getSprintName());
        existingEstimateRecord.setJiraId(estimateEntity.getJiraId());
        existingEstimateRecord.setDescription(estimateEntity.getDescription());
        existingEstimateRecord.setComplexity(estimateEntity.getComplexity());
        existingEstimateRecord.setComponent(estimateEntity.getComponent());
        existingEstimateRecord.setEstimatedPoints(estimateEntity.getEstimatedPoints());
        existingEstimateRecord.setEstimatedHours(estimateEntity.getEstimatedHours());
        existingEstimateRecord.setAssignee(estimateEntity.getAssignee());
        existingEstimateRecord.appendReason(estimateEntity.getReason());

        return estimateRepository.saveAndFlush(existingEstimateRecord);
    }

    @Override
    public void deleteEstimate(int jiraId) throws ResourceNotFoundException {
        Estimate existingEstimateRecord = (Estimate) estimateRepository.findByJiraId(jiraId)
                .orElseThrow(() -> new ResourceNotFoundException("Estimate not found for this id :: " + jiraId));
        estimateRepository.delete(existingEstimateRecord);
    }
}
