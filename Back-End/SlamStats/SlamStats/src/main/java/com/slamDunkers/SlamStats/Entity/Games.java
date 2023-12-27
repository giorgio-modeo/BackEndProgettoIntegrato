package com.slamDunkers.SlamStats.Entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
@Entity
@Getter
@Setter
@NoArgsConstructor
public class Games {
	@Id
	@Column(name = "ID", columnDefinition = "int")
	private int Id;

	@OneToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "season_ID", nullable = false)
	private Season season;


	@OneToOne(fetch = FetchType.EAGER)
	@JoinColumn(name="league_id", nullable = false)
	private League league;



	@Column(name = "home_team", columnDefinition = "int")
	private int homeTeam;
	@Column(name = "away_team", columnDefinition = "int")
	private int awayTeam;
	@Column(name = "start_date", columnDefinition = "datetime")
	private String startDate;
	@Column(name = "end_date", columnDefinition = "datetime")
	private String endDate;
	@Column(name = "stage", columnDefinition = "int")
	private int stage;
	@Column(name = "clock", columnDefinition = "time")
	private String clock;
	@Column(name = "halftime", columnDefinition = "tinyint(1)")
	private boolean halftime;
	@Column(name = "status", columnDefinition = "varchar(50)")
	private String status;
	@Column(name = "current_period", columnDefinition = "int")
	private int currentPeriod;
	@Column(name = "total_periods", columnDefinition = "int")
	private int totalPeriods;
	@Column(name = "area_name", columnDefinition = "varchar(100)")
	private String areaName;
	@Column(name = "arena_city", columnDefinition = "varchar(100)")
	private String arenaCity;
	@Column(name = "arena_state", columnDefinition = "varchar(2)")
	private String arenaState;
	@Column(name = "arena_country", columnDefinition = "varchar(50)")
	private String arenaCountry;


}
