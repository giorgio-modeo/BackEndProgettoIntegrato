package com.slamDunkers.SlamStats.Entity;

import jakarta.persistence.*;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@Entity
public class Teams {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@EqualsAndHashCode.Include
	@Column(name = "ID", columnDefinition = "int")
	private int Id;

	@Column(name = "name", columnDefinition = "string")
	private String Name;

	@Column(name = "nickname", columnDefinition = "string")
	private String Nickname;

	@Column(name = "code", columnDefinition = "string")
	private String Code;
	@Column(name = "city", columnDefinition = "string")
	private String City;

	@Column(name = "logo", columnDefinition = "string" )
	private String Logo;

	@Column(name = "AllStar", columnDefinition = "TINYINT(1)")
	private boolean AllStar;

	@Column(name = "nbaFranchise", columnDefinition = "TINYINT(1)")
	private boolean nbaFranchise;
//
//	@OneToOne
//	@JoinColumn(name = "league_id", nullable = false)
//	private int LEAGUE_ID;




}
