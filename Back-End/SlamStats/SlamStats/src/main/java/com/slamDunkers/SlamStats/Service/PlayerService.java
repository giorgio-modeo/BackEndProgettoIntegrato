package com.slamDunkers.SlamStats.Service;

import com.slamDunkers.SlamStats.Entity.Player;
import com.slamDunkers.SlamStats.Repository.PlayerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PlayerService {
	private PlayerRepository playerRepository;

	@Autowired
	public PlayerService(PlayerRepository playerRepository){this.playerRepository =playerRepository;}

	public List<Player> selezzionaTuttiGiocatori(){return playerRepository.findAll();}

	public Player selezionaGiocatore(int playerId){return playerRepository.findById(playerId);}
//
//	public List<Player> selezionaGiocatoriPerSquadra(String teamName){return playerRepository.findByTeamName(teamName);}


}
