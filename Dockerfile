FROM openjdk:19

WORKDIR /app

COPY ./Back-End/SlamStats/SlamStats \app

# Esponi la porta su cui l'app Java Spring ascolterà
EXPOSE 8080

# Comando per eseguire l'applicazione quando il container è avviato
 CMD mvn spring-boot:run