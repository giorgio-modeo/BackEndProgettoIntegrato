package com.slamDunkers.SlamStats.Controller;

import com.slamDunkers.SlamStats.Entity.Games;
import com.slamDunkers.SlamStats.Repository.GamesRepository;
import com.slamDunkers.SlamStats.Service.GamesService;
import com.slamDunkers.SlamStats.Service.PlayerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/games")
@CrossOrigin
public class GamesController {
	@Autowired
	private GamesService service;
	private GamesRepository repository;
	@Autowired
	public GamesController(GamesService service, GamesRepository repository) {
		this.service = service;
		this.repository = repository;
	}

	@GetMapping("/All")
	public List<Games> getGames() {
		return repository.findAll();
	}
	@GetMapping("/date")
	public List<Games> getGameByDate(String date) {
		return service.getGameByDate(date);
	}

	@GetMapping("/teamId")
	public List<Games> getGameByTeam(int teamId) {
		return service.getGameByTeam(teamId);
	}

}
