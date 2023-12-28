package com.slamDunkers.SlamStats.Service;

import com.slamDunkers.SlamStats.Entity.Games;
import com.slamDunkers.SlamStats.Entity.Teams;
import com.slamDunkers.SlamStats.Repository.GamesRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GamesService {

	private GamesRepository repository;

	public GamesService(GamesRepository repository) {
		this.repository = repository;
	}
	public List<Games> getGameByDate(String date) {
		return repository.findByStartDateContaining(date);
	}

	public List<Games> getGameByTeam(int teamId) {
		Teams team = new Teams();
		team.setId(teamId);
		return repository.findByHomeTeamOrAwayTeam(team, team);
	}

}
