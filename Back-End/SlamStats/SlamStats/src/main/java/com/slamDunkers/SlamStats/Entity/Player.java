package com.slamDunkers.SlamStats.Entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.Year;
import java.util.Date;


@Getter
@Setter
@NoArgsConstructor
@Entity
public class Player {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@EqualsAndHashCode.Include
	@Column(name = "id", columnDefinition = "int")
	private int Id;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "team_id ", nullable = false)
	private Teams team;

	@Column(name = "first_name", columnDefinition = "varchar(255)")
	private String firstName;

	@Column(name = "last_name", columnDefinition = "varchar(255)")
	private String lastName;

	@Column(name = "birth_date", columnDefinition = "date")
	private Date birthDate;

	@Column(name = "birth_Country", columnDefinition = "varchar(255)")
	private String birthCountry;

	@Column(name = "nba_Start", columnDefinition = "year")
	private Year nbaStart;

	@Column(name = "nba_pro", columnDefinition = "int")
	private Integer nbaPro;

	@Column(name = "height_feet", columnDefinition = "int")
	private Integer heightFeet;

	@Column(name = "height_inches", columnDefinition = "int")
	private Integer heightInches;

	@Column(name = "height_meters", columnDefinition = "decimal")
	private Double heightMeters;

	@Column(name = "weight_pounds", columnDefinition = "int")
	private Integer weightPounds;

	@Column(name = "weight_kg", columnDefinition = "decimal")
	private Double weightKilograms;

	@Column(name = "college", columnDefinition = "varchar(255)")
	private String college;

	@Column(name = "affiliation", columnDefinition = "varchar(255)")
	private String lastAffiliation;
}
