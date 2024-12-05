package com.dev.efficiency.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name="sprint")
@Entity
public class Sprint {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String projectCode;

    private String sprintName;

    private Date startDate;

    private Date endDate;

    private Date plannedReleaseDate;

    private String status;

    private String reason;

    private String deleted;

    public void appendReason(String newReason) {
        if (this.reason == null || this.reason.isEmpty()) {
            this.reason = newReason;
        } else {
            this.reason += ", " + newReason;
        }
    }

}
