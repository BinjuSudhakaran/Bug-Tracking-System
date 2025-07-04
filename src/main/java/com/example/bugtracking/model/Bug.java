package com.example.bugtracking.model;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name="bug")
public class Bug
{
	@Id
	private long bugId;
	private String bugTitle;
	private String status;
	private LocalDate createdDate;
	
	
	
	
	public void setProject(Project project) {
		this.project = project;
	}

	public void setAssignedTo(User assignedTo) {
		this.assignedTo = assignedTo;
	}
	@ManyToOne
    @JoinColumn(name = "project_id", nullable = false)
    private Project project;
	
	
	@ManyToOne
	@JoinColumn(name = "assigned_user_id", nullable = false)
	private User assignedTo;

	
	
	public Project getProject() {
		return project;
	}
	
	public User getAssignedTo() {
		return assignedTo;
	}
	
	public long getBugId() {
		return bugId;
	}
	public void setBugId(long bugId) {
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
	
	
	
	

}
