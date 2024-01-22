package com.slamDunkers.SlamStats.Service;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.DecodedJWT;
import com.slamDunkers.SlamStats.Entity.UserToken;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;

@Service
@Slf4j
class TokenService {
//			TODO cambiare il token e metteo in un file
//	        TODO cambiare le eccezioni da generiche a specifiche
	private static final String TOKEN_SECRET = "slamDunkersSlamStats2024";
	public static final int EXPIRE_AFTER = 3600000;
/*
* @param idUser id dell'utente
* @param role ruolo dell'utente
* @return token
* crea il token con l'id dell'utente e il suo ruolo usando l'algoritmo HMAC256
*
*/
	public String createToken(int idUser, String role){
		try{
			Algorithm algorithm=Algorithm.HMAC256(TOKEN_SECRET);
			return  JWT.create()
					.withClaim("idUser",idUser)
					.withClaim("role",role)
					.withIssuedAt(Instant.now())
					.withExpiresAt(Instant.now().plus(EXPIRE_AFTER, ChronoUnit.SECONDS))
					.sign(algorithm);
		}catch (Exception e){
			log.error(e.getMessage());
			throw new RuntimeException("problemi di creazione del token"+e.getMessage());
		}
	}


	public UserToken getUserIdFromToken(String token){
		try{
			Algorithm algorithm = Algorithm.HMAC256(TOKEN_SECRET);
			JWTVerifier verifier = JWT.require(algorithm).build();
			DecodedJWT jwt = verifier.verify(token);

			UserToken ut = new UserToken(jwt.getClaim("idUser").asInt(), jwt.getClaim("role").asString());
			return ut;
		} catch (Exception e){
			log.error(e.getMessage());
		}
		return null;
	}

	boolean isJWTExpired(DecodedJWT decodedJWT) {
		Date expiresAt = (Date) decodedJWT.getExpiresAt();
		return expiresAt.before(new Date( System.currentTimeMillis()));
	}



}
