package com.dev.efficiency.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Null;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class SprintDTO {


    private long id;

    @NotBlank(message = "Project code is mandatory")
    private String projectCode;
    @NotBlank(message = "Sprint name is mandatory")
    private String sprintName;
    @NotNull(message = "Start date is mandatory")
    private Date startDate;
    @NotNull(message = "End date is mandatory")
    private Date endDate;
    @NotNull(message = "Planned release date is mandatory")
    private Date plannedReleaseDate;
    @Pattern(regexp = "active|inactive", message = "Status must be either 'active' or 'not active'")
    private String status;
    private String reason;
    @Pattern(regexp = "Y|N", message = "Deleted must be either 'Y' or 'N'")
    private String deleteFlag;

}
