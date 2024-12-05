package com.dev.efficiency.dto;

public class DeveloperListDto {
	
	private String jiraId;
	private String jiraDescription;
	private Long devCompletition;
	private Long estimatedHours;
	private Long hoursSpent;
	private Long remainingHours;
	private String remarks;
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
	
	

}
