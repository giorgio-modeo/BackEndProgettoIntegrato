package com.slamDunkers.SlamStats.Repository;
import com.slamDunkers.SlamStats.Entity.Player;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface PlayerRepository extends JpaRepository<Player,Integer> {
	@Override
	List<Player> findAll();

	Player findById(int Id);

//	List<Player> findByTeamName(String teamName);

}
