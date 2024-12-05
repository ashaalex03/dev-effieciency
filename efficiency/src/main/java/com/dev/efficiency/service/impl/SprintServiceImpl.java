package com.dev.efficiency.service.impl;

import com.dev.efficiency.entity.Sprint;
import com.dev.efficiency.exception.ResourceNotFoundException;
import com.dev.efficiency.exception.SprintNotFoundException;
import com.dev.efficiency.repository.SprintRepository;
import com.dev.efficiency.repository.UserRepository;
import com.dev.efficiency.service.SprintService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SprintServiceImpl implements SprintService {

    @Autowired
    private SprintRepository sprintRepository;

    @Autowired
    private UserRepository userRepository;

    @Override
    public Sprint createSprint(Sprint sprintEntity) throws ResourceNotFoundException {
        boolean isProjectCodeExists = userRepository.existsByProjectCode(sprintEntity.getProjectCode());
        if(!isProjectCodeExists){
            throw new ResourceNotFoundException("Project code not found to create the Sprint:: " + sprintEntity.getProjectCode());
        }
        return sprintRepository.saveAndFlush(sprintEntity);
    }

    @Override
    public List<Sprint> getSprintDetails(String projectCode) throws ResourceNotFoundException {

        List<Sprint> sprintEntities = sprintRepository.findAllByProjectCodeAndDeleted(projectCode,"N");
        if (sprintEntities.isEmpty()) {
            throw new ResourceNotFoundException("Sprint not found for this project code :: " + projectCode);
        }
        return sprintEntities;
    }

    @Override
    public Sprint updateSprint(Sprint sprintEntity) throws ResourceNotFoundException {
        Sprint existingSprintRecord = sprintRepository.findById(sprintEntity.getId())
                .orElseThrow(() -> new ResourceNotFoundException("Sprint not found for this id :: " + sprintEntity.getId()));

        existingSprintRecord.appendReason(sprintEntity.getReason());
        existingSprintRecord.setStatus(sprintEntity.getStatus());
        existingSprintRecord.setSprintName(sprintEntity.getSprintName());
        existingSprintRecord.setStartDate(sprintEntity.getStartDate());
        existingSprintRecord.setEndDate(sprintEntity.getEndDate());
        existingSprintRecord.setPlannedReleaseDate(sprintEntity.getPlannedReleaseDate());

        return sprintRepository.saveAndFlush(existingSprintRecord);

    }

    @Override
    public void deleteSprint(long sprintId,String reason) throws ResourceNotFoundException {
        Sprint existingSprintRecord = sprintRepository.findById(sprintId)
                .orElseThrow(() -> new ResourceNotFoundException("Sprint not found for this id :: " + sprintId));
        if(existingSprintRecord.getDeleted().equals("Y")){
            throw new SprintNotFoundException("Sprint already deleted for this id :: " + sprintId);
        }
        existingSprintRecord.setDeleted("Y");
        existingSprintRecord.appendReason(reason);
        sprintRepository.saveAndFlush(existingSprintRecord);

    }

}
