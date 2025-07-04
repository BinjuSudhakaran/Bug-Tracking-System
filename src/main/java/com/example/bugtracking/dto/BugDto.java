package com.example.bugtracking.dto;

import java.time.LocalDate;

public class BugDto 
{
	private Long bugId;
	private String bugTitle;
	private String status;
	private LocalDate createdDate;
	private Long projectId;
	private Long assignTo;
	
	public BugDto() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public Long getBugId() {
		return bugId;
	}

	public void setBugId(Long bugId) {
		this.bugId = bugId;
	}

	public String getBugTitle() {
		return bugTitle;
	}

	public void setBugTitle(String bugTitle) {
		this.bugTitle = bugTitle;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public LocalDate getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(LocalDate createdDate) {
		this.createdDate = createdDate;
	}

	public Long getProjectId() {
		return projectId;
	}

	public void setProjectId(Long projectId) {
		this.projectId = projectId;
	}

	public Long getAssignTo() {
		return assignTo;
	}

	public void setAssignTo(Long assignTo) {
		this.assignTo = assignTo;
	}

	public BugDto(long bugId, String bugTitle, String status, LocalDate createdDate, long projectId, long assignTo) {
		super();
		this.bugId = bugId;
		this.bugTitle = bugTitle;
		this.status = status;
		this.createdDate = createdDate;
		this.projectId = projectId;
		this.assignTo = assignTo;
	}

}
