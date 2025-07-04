package com.example.bugtracking.dto;

public class Userdto
{
	private long userId;
	  private String userName;
	  private String userRole;
	  //private Long projectId;
	public long getUserId() {
		return userId;
	}
	public void setUserId(long userId) {
		this.userId = userId;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getUserRole() {
		return userRole;
	}
	public void setUserRole(String userRole) {
		this.userRole = userRole;
	}
	/*public Long getProjectId() {
		return projectId;
	}
	public void setProjectId(Long projectId) {
		this.projectId = projectId;
	}*/
	public Userdto(long userId, String userName, String userRole, Long projectId) {
		super();
		this.userId = userId;
		this.userName = userName;
		this.userRole = userRole;
		//this.projectId = projectId;
	}
	public Userdto() {
		// TODO Auto-generated constructor stub
	}

}
