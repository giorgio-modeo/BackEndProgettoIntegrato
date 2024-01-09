FROM openjdk:19

WORKDIR /app

COPY ./Back-End/SlamStats \app

# Compila il tuo progetto con Maven
RUN ./mvnw clean install

# Esponi la porta su cui l'app Java Spring ascolterà
EXPOSE 8080

# Comando per eseguire l'applicazione quando il container è avviato
CMD ["./mvnw", "spring-boot:run"]