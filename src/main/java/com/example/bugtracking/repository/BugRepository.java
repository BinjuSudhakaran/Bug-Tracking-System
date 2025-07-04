package com.example.bugtracking.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import com.example.bugtracking.model.Bug;

public interface BugRepository extends JpaRepository<Bug, Long>
{
	
	@Query(value = "SELECT * FROM bug WHERE status = 'OPEN' AND assigned_user_id = :userId", nativeQuery = true)
    List<Bug> findOpenBugsByUser(@Param("userId") Long userId);

	
	@Query(value = "SELECT * FROM bug WHERE created_date >= CURRENT_DATE - INTERVAL 7 DAY", nativeQuery = true)
	List<Bug> findBugsCreatedInLast7Days();
	
}
