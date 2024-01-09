FROM maven:3.8.4-openjdk-19-slim

WORKDIR /app

COPY ./Back-End/SlamStats/SlamStats \app


# Esponi la porta su cui l'app Java Spring ascolterà
EXPOSE 8080
CMD cut HELP
# Comando per eseguire l'applicazione quando il container è avviato
CMD mvn spring-boot:run