package com.dev.efficiency.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Positive;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class EstimateDTO {

    private long sprintId;
    @NotBlank(message = "Sprint Name is mandatory")
    private String sprintName;
    @NotBlank(message = "Jira ID is mandatory")
    private int jiraId;
    @NotBlank(message = "Description is mandatory")
    private String description;
    @NotBlank(message = "Complexity is mandatory")
    @Pattern(regexp = "^(Low|Medium|High|Critical)$", message = "Complexity should be Low, Medium or High")
    private String complexity;
    @NotBlank(message = "Component is mandatory")
    @Pattern(regexp = "^(UI|Backend|Database)$", message = "Component should be UI, Backend or Database")
    private String component;
    @NotBlank(message = "Estimated Points is mandatory")
    @Positive(message = "Estimated Points should be positive")
    private float estimatedPoints;
    @NotBlank(message = "Estimated Hours is mandatory")
    @Positive(message = "Estimated Hours should be positive")
    private float estimatedHours;
    @NotBlank(message = "Assignee is mandatory")
    private String assignee;

    private String status;
    private String reason;
}
