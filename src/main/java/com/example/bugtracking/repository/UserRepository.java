package com.example.bugtracking.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.bugtracking.model.User;

public interface UserRepository extends JpaRepository<User, Long>
{

}
