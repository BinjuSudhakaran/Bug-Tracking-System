package com.example.bugtracking.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.bugtracking.dto.Userdto;
import com.example.bugtracking.model.User;
import com.example.bugtracking.service.UserService;

@RestController
@RequestMapping("/api/user")
public class UserController 
{
	@Autowired
	private UserService userService;
	
	@PostMapping
    public ResponseEntity<Userdto> addUser(@RequestBody Userdto dto)
	{
        Userdto saved = userService.addUser(dto);
        return ResponseEntity.ok(saved);
    }
	
	@GetMapping
	public ResponseEntity<List<Userdto>> getAllUsers() 
	{
	    List<Userdto> dtos = userService.getAllUsers();
	    return ResponseEntity.ok(dtos);
	}

	

}
