package com.dev.efficiency.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name="estimate")
@Entity
public class Estimate {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long sprintId;
    private String sprintName;
    private int jiraId;
    private String description;
    private String complexity;
    private String component;
    private float estimatedPoints;
    private float estimatedHours;
    private String assignee;
    private String status;
    private String reason;

    public void appendReason(String newReason) {
        if (this.reason == null || this.reason.isEmpty()) {
            this.reason = newReason;
        } else {
            this.reason += ", " + newReason;
        }
    }
}
