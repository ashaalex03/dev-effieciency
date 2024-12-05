package com.dev.efficiency.mapper;

import com.dev.efficiency.dto.SprintDTO;
import com.dev.efficiency.entity.Sprint;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class SprintMapper {

    public static SprintDTO toSprintDTO(Sprint entity) {
        SprintDTO dto = new SprintDTO();
        dto.setId(entity.getId());
        dto.setSprintName(entity.getSprintName());
        dto.setReason(entity.getReason());
        dto.setEndDate(entity.getEndDate());
        dto.setStatus(entity.getStatus());
        dto.setProjectCode(entity.getProjectCode());
        dto.setStartDate(entity.getStartDate());
        dto.setPlannedReleaseDate(entity.getPlannedReleaseDate());
        dto.setDeleteFlag(entity.getDeleted());
        return dto;
    }

    public static Sprint toSprint(SprintDTO sprintDTO) {
        Sprint entity = new Sprint();
        entity.setId(sprintDTO.getId());
        entity.setSprintName(sprintDTO.getSprintName());
        entity.setReason(sprintDTO.getReason());
        entity.setEndDate(sprintDTO.getEndDate());
        entity.setStatus(sprintDTO.getStatus());
        entity.setProjectCode(sprintDTO.getProjectCode());
        entity.setStartDate(sprintDTO.getStartDate());
        entity.setPlannedReleaseDate(sprintDTO.getPlannedReleaseDate());
        entity.setDeleted(sprintDTO.getDeleteFlag());
        return entity;
    }

    public static List<SprintDTO> toSprintDTOList(List<Sprint> sprintDetails) {

        return sprintDetails.stream().map(SprintMapper::toSprintDTO).collect(Collectors.toList());
    }
}
