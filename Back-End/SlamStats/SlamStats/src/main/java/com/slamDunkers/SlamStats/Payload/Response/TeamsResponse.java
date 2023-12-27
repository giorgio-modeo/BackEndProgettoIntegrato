package com.slamDunkers.SlamStats.Payload.Response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class TeamsResponse {
	private String TeamName;
	private String City;
	private String Logo;
	private String Nickname;
	private boolean AllStar;
	private boolean nbaFranchise;
	private String LeagueName;
	private String ConferenceName;
	private String DivisionName;

	public TeamsResponse(String name, String city, String logo, String nickname, boolean allStar, boolean nbaFranchise, String name1, String conference) {
	}
}
