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
	private Integer Id;

	@Column(name = "name", columnDefinition = "varchar(255)")
	private String Name;

	@Column(name = "nickname", columnDefinition = "varchar(255)")
	private String Nickname;

	@Column(name = "code", columnDefinition = "varchar(255)")
	private String Code;
	@Column(name = "city", columnDefinition = "varchar(255)")
	private String City;

	@Column(name = "logo", columnDefinition = "varchar(255)" )
	private String Logo;

	@Column(name = "all_star", columnDefinition = "tinyint(1)")
	private boolean AllStar;

	@Column(name = "nbaFranchise", columnDefinition = "tinyint(1)")
	private boolean nbaFranchise;

@OneToOne(fetch = FetchType.EAGER)
	@JoinColumn(name="league_id", nullable = false)
	private League league;


	public TeamsResponse toTeamsResponse() {

		if (this.league.getDivisionId() == null) {
			TeamsResponse teamsResponse = new TeamsResponse(
					this.Name,
					this.City,
					this.Logo,
					this.Nickname,
					this.AllStar,
					this.nbaFranchise,
					this.league.getName(),
					this.league.getConference()

			);
			return teamsResponse;

		}
		TeamsResponse teamsResponse = new TeamsResponse(
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
		return teamsResponse;



	}


}
