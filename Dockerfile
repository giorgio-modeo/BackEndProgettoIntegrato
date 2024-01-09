FROM maven:3.9.6-eclipse-temurin-21-jammy

WORKDIR /app

COPY ./Back-End/SlamStats/SlamStats \app


# Esponi la porta su cui l'app Java Spring ascolterà
EXPOSE 8080

CMD ["mvn", "spring-boot:run"]