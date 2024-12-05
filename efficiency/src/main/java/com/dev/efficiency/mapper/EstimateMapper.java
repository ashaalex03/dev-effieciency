package com.dev.efficiency.mapper;

import java.util.List;
import java.util.stream.Collectors;
import com.dev.efficiency.dto.EstimateDTO;
import com.dev.efficiency.entity.Estimate;
public class EstimateMapper {

    // Convert Estimate entity to EstimateDTO
    public static EstimateDTO toDTO(Estimate estimate) {

        EstimateDTO dto = new EstimateDTO();
        dto.setSprintId(estimate.getSprintId());
        dto.setSprintName(estimate.getSprintName());
        dto.setJiraId(estimate.getJiraId());
        dto.setDescription(estimate.getDescription());
        dto.setComplexity(estimate.getComplexity());
        dto.setComponent(estimate.getComponent());
        dto.setEstimatedPoints(estimate.getEstimatedPoints());
        dto.setEstimatedHours(estimate.getEstimatedHours());
        dto.setAssignee(estimate.getAssignee());
        dto.setStatus(estimate.getStatus());
        dto.setReason(estimate.getReason());
        return dto;
    }

    // Convert EstimateDTO to Estimate entity
    public static Estimate toEntity(EstimateDTO estimateDTO) {


        Estimate estimate = new Estimate();
        estimate.setSprintId(estimateDTO.getSprintId());
        estimate.setSprintName(estimateDTO.getSprintName());
        estimate.setJiraId(estimateDTO.getJiraId());
        estimate.setDescription(estimateDTO.getDescription());
        estimate.setComplexity(estimateDTO.getComplexity());
        estimate.setComponent(estimateDTO.getComponent());
        estimate.setEstimatedPoints(estimateDTO.getEstimatedPoints());
        estimate.setEstimatedHours(estimateDTO.getEstimatedHours());
        estimate.setAssignee(estimateDTO.getAssignee());
        estimate.setStatus(estimateDTO.getStatus());
        estimate.setReason(estimateDTO.getReason());
        return estimate;
    }

    // Convert a list of Estimate entities to a list of EstimateDTOs
    public static List<EstimateDTO> toDTOList(List<Estimate> estimates) {
        return estimates.stream()
                .map(EstimateMapper::toDTO)
                .collect(Collectors.toList());
    }

    // Convert a list of EstimateDTOs to a list of Estimate entities
    public static List<Estimate> toEntityList(List<EstimateDTO> estimateDTOs) {
        return estimateDTOs.stream()
                .map(EstimateMapper::toEntity)
                .collect(Collectors.toList());
    }
}
