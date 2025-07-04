package com.example.bugtracking.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.bugtracking.model.Project;

public interface ProjectRepository extends JpaRepository<Project, Long> 
{

}
