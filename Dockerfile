# Usa un'immagine base con Java 19
FROM openjdk:19

# Imposta il working directory all'interno del container
WORKDIR /app

# Copia il file JAR dell'app nella directory del container
COPY target/tuo-app.jar /app/tuo-app.jar

# Esponi la porta su cui l'app Java Spring ascolterà
EXPOSE 8080

# Comando per eseguire l'applicazione quando il container è avviato
CMD ["java", "-jar", "tuo-app.jar"]