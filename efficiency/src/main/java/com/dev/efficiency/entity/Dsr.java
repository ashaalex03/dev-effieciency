package com.dev.efficiency.entity;


import jakarta.persistence.*;

@Entity
@Table(name = "DSR")
public class Dsr {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long dsrId;
	private String jiraId;

	private String jiraDescription;
	private Long devCompletition;
	private Long estimatedHours;
	private Long hoursSpent;
	private Long remainingHours;
	private String remarks;
	private String sprintName;
	private String name;
	private String reason;
	private String deleted;


	
	public String getDeleted() {
		return deleted;
	}
	public void setDeleted(String deleted) {
		this.deleted = deleted;
	}
	public String getReason() {
		return reason;
	}
	public void setReason(String reason) {
		this.reason = reason;
	}
	public String getJiraId() {
		return jiraId;
	}
	public void setJiraId(String jiraId) {
		this.jiraId = jiraId;
	}
	public String getJiraDescription() {
		return jiraDescription;
	}
	public void setJiraDescription(String jiraDescription) {
		this.jiraDescription = jiraDescription;
	}
	public Long getDevCompletition() {
		return devCompletition;
	}
	public void setDevCompletition(Long devCompletition) {
		this.devCompletition = devCompletition;
	}
	public Long getEstimatedHours() {
		return estimatedHours;
	}
	public void setEstimatedHours(Long estimatedHours) {
		this.estimatedHours = estimatedHours;
	}
	public Long getHoursSpent() {
		return hoursSpent;
	}
	public void setHoursSpent(Long hoursSpent) {
		this.hoursSpent = hoursSpent;
	}
	public Long getRemainingHours() {
		return remainingHours;
	}
	public void setRemainingHours(Long remainingHours) {
		this.remainingHours = remainingHours;
	}
	public String getRemarks() {
		return remarks;
	}
	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}
	public String getSprintName() {
		return sprintName;
	}
	public void setSprintName(String sprintName) {
		this.sprintName = sprintName;
	}
	
	public Long getDsrId() {
		return dsrId;
	}
	public void setDsrId(Long dsrId) {
		this.dsrId = dsrId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Dsr(Long dsrId, String jiraId, String jiraDescription, Long devCompletition, Long estimatedHours,
               Long hoursSpent, Long remainingHours, String remarks, String sprintName, String name, String reason,
               String deleted) {
		super();
		this.dsrId = dsrId;
		this.jiraId = jiraId;
		this.jiraDescription = jiraDescription;
		this.devCompletition = devCompletition;
		this.estimatedHours = estimatedHours;
		this.hoursSpent = hoursSpent;
		this.remainingHours = remainingHours;
		this.remarks = remarks;
		this.sprintName = sprintName;
		this.name = name;
		this.reason = reason;
		this.deleted = deleted;
	}
	public Dsr() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "Dsr [dsrId=" + dsrId + ", jiraId=" + jiraId + ", jiraDescription=" + jiraDescription
				+ ", devCompletition=" + devCompletition + ", estimatedHours=" + estimatedHours + ", hoursSpent="
				+ hoursSpent + ", remainingHours=" + remainingHours + ", remarks=" + remarks + ", sprintName="
				+ sprintName + ", name=" + name + ", reason=" + reason + ", deleted=" + deleted + "]";
	}

	
}
