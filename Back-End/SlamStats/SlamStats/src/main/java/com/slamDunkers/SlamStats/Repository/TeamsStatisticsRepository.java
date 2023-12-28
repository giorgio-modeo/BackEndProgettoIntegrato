package com.slamDunkers.SlamStats.Repository;

import com.slamDunkers.SlamStats.Entity.TeamsStatistics;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TeamsStatisticsRepository extends JpaRepository<TeamsStatistics,Integer> {
	
}
