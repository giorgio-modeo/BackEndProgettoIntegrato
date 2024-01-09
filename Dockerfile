FROM maven:3.9.6-amazoncorretto-17-al2023

WORKDIR /app

COPY ./Back-End/SlamStats/SlamStats \app


# Esponi la porta su cui l'app Java Spring ascolterà
EXPOSE 8080

