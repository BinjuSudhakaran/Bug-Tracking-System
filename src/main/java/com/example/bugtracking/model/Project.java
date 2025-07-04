package com.example.bugtracking.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="project")
public class Project 
{
	@Id
	private long projectId;
	
	private String projectName;
	
	//@OneToMany(mappedBy = "project", cascade = CascadeType.ALL)
    //private List<User> users;
	
	
	
	@OneToMany(mappedBy = "project", cascade = CascadeType.ALL)
	private List<Bug> bugs;

	
	
	/*public List<User> getUsers() {
		return users;
	}
	public void setUsers(List<User> users) {
		this.users = users;
	}*/
	public List<Bug> getBugs() {
		return bugs;
	}
	public void setBugs(List<Bug> bugs) {
		this.bugs = bugs;
	}
	public long getProjectId() {
		return projectId;
	}
	public void setProjectId(long projectId) {
		this.projectId = projectId;
	}
	public String getProjectName() {
		return projectName;
	}
	public void setProjectName(String projectName) {
		this.projectName = projectName;
	}

}
