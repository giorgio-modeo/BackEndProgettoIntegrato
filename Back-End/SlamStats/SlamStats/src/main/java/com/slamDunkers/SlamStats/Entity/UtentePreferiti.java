package com.slamDunkers.SlamStats.Entity;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UtentePreferiti {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "utente", nullable = false)
	private Utente idUtente;

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "team")
	private Teams idTeam;

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "articolo")
	private Blog idArticolo;


}
