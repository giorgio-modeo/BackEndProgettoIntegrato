FROM eclipse-temurin:8-jdk-alpine

WORKDIR /app

COPY ./Back-End/SlamStats/SlamStats \app


# Esponi la porta su cui l'app Java Spring ascolterà
EXPOSE 8080

CMD ["mvn", "spring-boot:run"]