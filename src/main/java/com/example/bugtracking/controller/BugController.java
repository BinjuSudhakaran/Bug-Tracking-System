package com.example.bugtracking.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.example.bugtracking.dto.BugDto;
import com.example.bugtracking.service.BugService;

@RestController
@RequestMapping("/api/bug")
public class BugController 
{
	@Autowired
	private BugService bugService;
	@PostMapping()
	public ResponseEntity<?> addBug(@RequestBody BugDto bugDto)
	{
		BugDto result=bugService.addBug(bugDto);
		return ResponseEntity.ok(result);
	}
	
	@GetMapping
	public ResponseEntity<List<BugDto>> viewAllBugs()
	{
		List<BugDto> result= bugService.viewAllBugs();
		return ResponseEntity.ok(result);
	}
	
	@GetMapping("/{bugId}")
	public ResponseEntity<?> getBugsbyId(@PathVariable long bugId)
	{
		try
		{
			List<BugDto> bug=bugService.getBugsbyId(bugId);
			return ResponseEntity.ok(bug);
		}
		catch(Exception e)
		{
			return ResponseEntity.badRequest().body(e.getMessage());
		}
			
	}
	
	@DeleteMapping("/delete/{bugId}")
	public ResponseEntity<String> deleteBug(@PathVariable long bugId)
	{
		try 
		{
			bugService.deleteBug(bugId);
			return ResponseEntity.ok("Bug Deleted");
		} 
		catch (Exception e) 
		{
			return ResponseEntity.badRequest().body(e.getMessage());
		}
		
	}
	
	@PutMapping("/update/{bugId}")
	public ResponseEntity<?> updateBug(@PathVariable Long bugId,@RequestBody BugDto bugDto)
	{

		try 
		{
			BugDto result = bugService.updateBug(bugId,bugDto);
			return ResponseEntity.ok(result);
		} 
		catch (Exception e)
		{
			return ResponseEntity.badRequest().body(e.getMessage());
		}
		
	}
	
	@GetMapping("/open/{userId}")
    public ResponseEntity<?> getOpenBugs(@PathVariable Long userId) 
	{
        try
        {
        	List<BugDto> result =bugService.getOpenBugsByUser(userId);
        	return ResponseEntity.ok(result);
			
		} 
        catch (Exception e) 
        {
        	return ResponseEntity.badRequest().body(e.getMessage());
		}
    }
	
	@GetMapping("/recent")
    public List<BugDto> getRecentBugs() 
	{
        return bugService.getRecentBugs();
    }

	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
