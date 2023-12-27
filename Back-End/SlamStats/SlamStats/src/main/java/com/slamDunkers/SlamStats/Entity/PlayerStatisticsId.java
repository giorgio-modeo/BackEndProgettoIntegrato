package com.slamDunkers.SlamStats.Entity;

import jakarta.persistence.Embeddable;
import jakarta.persistence.FetchType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

@NoArgsConstructor
@Getter
@Setter
@EqualsAndHashCode
@Embeddable
public class PlayerStatisticsId implements Serializable {

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "team_ID ", nullable = false)
	private Teams team;

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "player_ID ", nullable = false)
	private Player player;

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "game_ID ", nullable = false)
	private Games game;
}
