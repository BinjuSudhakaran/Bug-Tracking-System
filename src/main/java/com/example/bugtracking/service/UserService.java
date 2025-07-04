package com.example.bugtracking.service;

import java.util.List;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.bugtracking.dto.Userdto;
import com.example.bugtracking.model.User;
import com.example.bugtracking.repository.UserRepository;
@Service
public class UserService
{
	@Autowired
	private UserRepository userRepository;
	
	public Userdto addUser(Userdto dto) 
	{
        User user = new User();
        user.setUserId(dto.getUserId());
        user.setUserName(dto.getUserName());
        user.setUserRole(dto.getUserRole());
        User saved = userRepository.save(user);
        Userdto result = new Userdto();
        result.setUserId(saved.getUserId());
        result.setUserName(saved.getUserName());
        result.setUserRole(saved.getUserRole());
        return result;
    }
	
	public List<Userdto> getAllUsers() 
	{
	    return userRepository.findAll().stream()
	        .map(user -> {
	            Userdto dto = new Userdto();
	            dto.setUserId(user.getUserId());
	            dto.setUserName(user.getUserName());
	            dto.setUserRole(user.getUserRole());
	            return dto;
	        })
	        .collect(Collectors.toList());
	}

}
