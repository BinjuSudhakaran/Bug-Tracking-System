package com.example.bugtracking.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.bugtracking.dto.BugDto;
import com.example.bugtracking.model.Bug;
import com.example.bugtracking.model.Project;
import com.example.bugtracking.model.User;
import com.example.bugtracking.repository.BugRepository;
import com.example.bugtracking.repository.ProjectRepository;
import com.example.bugtracking.repository.UserRepository;

@Service
public class BugService 
{
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private ProjectRepository projectRepository;
	
	@Autowired
	private BugRepository bugRepository;
	
	public BugDto addBug(BugDto bugDto) throws Exception
	{
		Bug b=new Bug();
		b.setBugId(bugDto.getBugId());
		b.setBugTitle(bugDto.getBugTitle());
		b.setStatus(bugDto.getStatus());
		b.setCreatedDate(bugDto.getCreatedDate());
	
		User user = userRepository.findById(bugDto.getAssignTo()).orElseThrow(() -> new RuntimeException("User not found"));
        Project project = projectRepository.findById(bugDto.getProjectId()).orElseThrow(() -> new RuntimeException("Project not found"));
  
        b.setAssignedTo(user);
        b.setProject(project);
        
        Bug saved = bugRepository.save(b);

       
        BugDto result = new BugDto();	
        result.setBugId(saved.getBugId());
        result.setBugTitle(saved.getBugTitle());
        result.setStatus(saved.getStatus());
        result.setCreatedDate(saved.getCreatedDate());
        result.setAssignTo(saved.getAssignedTo().getUserId());
        result.setProjectId(saved.getProject().getProjectId());
        return result;
				
		
		
	}

	public List<BugDto> viewAllBugs() 
	{
        List<Bug> bugs=bugRepository.findAll();
        return bugs.stream().map(b->new BugDto(b.getBugId(),b.getBugTitle(),b.getStatus(),b.getCreatedDate(),b.getProject().getProjectId(),b.getAssignedTo().getUserId())).collect(Collectors.toList());
    
	}

	public List<BugDto> getBugsbyId(long bugId) throws Exception
	{
		Optional<Bug> bug= bugRepository.findById(bugId);
		if (bug.isEmpty()) 
		{
		      throw new RuntimeException("No bugs found with id: " + bugId);
		}
		return bug.stream().map(b->new BugDto(b.getBugId(),b.getBugTitle(),b.getStatus(),b.getCreatedDate(),b.getProject().getProjectId(),b.getAssignedTo().getUserId())).collect(Collectors.toList());
	}

	public void deleteBug(long bugId) throws Exception
	{
		Optional<Bug> bug= bugRepository.findById(bugId);
		if (bug.isEmpty()) 
		{
		      throw new RuntimeException("No bugs found with id: " + bugId);
		}
		
		bugRepository.deleteById(bugId);
	}

	public BugDto updateBug(long bugId, BugDto bugDto) throws Exception
	{
		Bug bug=bugRepository.findById(bugId).orElseThrow(()->new RuntimeException("No Such bug found"));
		bug.setBugTitle(bugDto.getBugTitle());
		bug.setStatus(bugDto.getStatus());
		bug.setCreatedDate(bugDto.getCreatedDate());
		
	    if (bugDto.getAssignTo() != null)
	    {
	    	User user = userRepository.findById(bugDto.getAssignTo()).orElseThrow(() -> new RuntimeException("User not found"));
	    }

	    if (bugDto.getProjectId() != null) 
	    {
	        Project project = projectRepository.findById(bugDto.getProjectId()) .orElseThrow(() -> new RuntimeException("Project not found"));
	        bug.setProject(project);
	    }

	    Bug saved = bugRepository.save(bug);

	       
        BugDto result = new BugDto();
        result.setBugId(saved.getBugId());
        result.setBugTitle(saved.getBugTitle());
        result.setStatus(saved.getStatus());
        result.setCreatedDate(saved.getCreatedDate());
        result.setAssignTo(saved.getAssignedTo().getUserId());
        result.setProjectId(saved.getProject().getProjectId());
        return result;
	}

	public List<BugDto> getOpenBugsByUser(Long userId) throws Exception
	{
         List<Bug> bug=bugRepository.findOpenBugsByUser(userId);
         if(bug.isEmpty())
         {
        	 throw new Exception("user not found with id:"+userId);
         }
         
         return bug.stream().map(b->new BugDto(b.getBugId(),b.getBugTitle(),b.getStatus(),b.getCreatedDate(),b.getProject().getProjectId(),b.getAssignedTo().getUserId())).collect(Collectors.toList());
    }
	
	public List<BugDto> getRecentBugs()
{
        List<Bug> bug=bugRepository.findBugsCreatedInLast7Days();
        
        return bug.stream().map(b->new BugDto(b.getBugId(),b.getBugTitle(),b.getStatus(),b.getCreatedDate(),b.getProject().getProjectId(),b.getAssignedTo().getUserId())).collect(Collectors.toList());
    }

}
