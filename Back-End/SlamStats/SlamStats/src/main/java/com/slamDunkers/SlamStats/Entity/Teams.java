package com.slamDunkers.SlamStats.Entity;


import com.slamDunkers.SlamStats.Payload.Response.TeamsResponse;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
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

	@Column(name = "all_star", columnDefinition = "tinyint(1)")
	private boolean AllStar;

	@Column(name = "nbaFranchise", columnDefinition = "TINYINT(1)")
	private boolean nbaFranchise;

	@OneToOne(fetch = FetchType.EAGER)
	@JoinColumn(name="league_id", nullable = false)
	private League league;


	public TeamsResponse toTeamsResponse() {
		return new TeamsResponse(
				this.Name,
				this.City,
				this.Logo,
				this.Nickname,
				this.AllStar,
				this.nbaFranchise,
				this.league.getName(),
				this.league.getConference(),
				this.league.getDivision()
		);
	}


}
