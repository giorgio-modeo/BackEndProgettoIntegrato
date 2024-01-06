package com.slamDunkers.SlamStats.Service;

import com.slamDunkers.SlamStats.Entity.Games;
import com.slamDunkers.SlamStats.Entity.Scores;
import com.slamDunkers.SlamStats.Entity.Teams;
import com.slamDunkers.SlamStats.Payload.Response.CalendarioDateResponse;
import com.slamDunkers.SlamStats.Payload.Response.CalendarioResponse;
import com.slamDunkers.SlamStats.Repository.GamesRepository;
import com.slamDunkers.SlamStats.Repository.ScoreRepository;
import com.slamDunkers.SlamStats.Repository.TeamsRepository;
import org.springframework.stereotype.Service;

import java.util.*;


@Service
public class GamesService {

	private final GamesRepository repository;
	private final ScoreRepository scoreRepository;
	private final TeamsRepository teamsRepository;

	public GamesService(GamesRepository repository,TeamsRepository teamsRepository, ScoreRepository scoreRepository) {
		this.repository = repository;
		this.teamsRepository = teamsRepository;
		this.scoreRepository = scoreRepository;
	}
	public List<CalendarioDateResponse> getGameByDate(String date) {
		List<Games> games = repository.findByStartDateContaining(date);
		return toCalendarioDateResponse(games);

	}
	public List<CalendarioDateResponse> getGames(){
		List<Games> games = repository.findAll();
		return toCalendarioDateResponse(games);

	}
	public List<Games> getGameByTeam(int teamId) {
		Teams team = new Teams();
		team.setId(teamId);
		return repository.findByHomeTeamOrAwayTeam(team, team);
	}

	public List<CalendarioDateResponse> partiteGiocateSquadra(int idSquadra) {
		//prendere tutti i games della squadra
		Optional<Teams> optionalTeam = teamsRepository.findById(idSquadra);
		Teams team = optionalTeam.orElseThrow(() -> new NoSuchElementException("Team not found"));
		List<Games> games = repository.findByHomeTeamOrAwayTeam(team, team);
		return toCalendarioDateResponse(games);
	}
	public List<CalendarioDateResponse> toCalendarioDateResponse(List<Games> games){
		List<CalendarioDateResponse> calendarioResponseList = new ArrayList<>();
		for (Games game : games)
		{
			CalendarioDateResponse calendario = new CalendarioDateResponse() ;
			calendario.setGameid(game.getId());
			calendario.setGameStartDate(game.getStartDate());
			calendario.setTeamHomeName(game.getHomeTeam().getTeamName());
			calendario.setTeamAwayName(game.getAwayTeam().getTeamName());
			calendario.setScoreTeamHome(scoreRepository.findByGameAndTeam(game, game.getHomeTeam()).getPoints());
			calendario.setScoreTeamAway(scoreRepository.findByGameAndTeam(game, game.getAwayTeam()).getPoints());
			calendario.setConferenceNameHome(game.getHomeTeam().getLeague().getConference());
			calendario.setConferenceNameAway(game.getAwayTeam().getLeague().getConference());
			calendario.setDivisionNameHome(game.getHomeTeam().getLeague().getDivision());
			calendario.setDivisionNameAway(game.getAwayTeam().getLeague().getDivision());
			calendario.setTeamIdHome(game.getHomeTeam().getId());
			calendario.setTeamIdAway(game.getAwayTeam().getId());
			calendario.setAllStarHome(game.getHomeTeam().isAllStar());
			calendario.setAllStarAway(game.getAwayTeam().isAllStar());
			calendario.setNicknameHome(game.getHomeTeam().getNickname());
			calendario.setNicknameAway(game.getAwayTeam().getNickname());
			calendario.setLogoHome(game.getHomeTeam().getLogo());
			calendario.setLogoAway(game.getAwayTeam().getLogo());
			calendario.setCityHome(game.getHomeTeam().getCity());
			calendario.setCityAway(game.getAwayTeam().getCity());
			calendario.setCodeHome(game.getHomeTeam().getCode());
			calendario.setCodeAway(game.getAwayTeam().getCode());

			calendarioResponseList.add(calendario);
		}
		return calendarioResponseList;
	}

}
