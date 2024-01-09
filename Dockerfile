FROM maven:3.9.6-amazoncorretto-17-al2023

WORKDIR /app

COPY ./Back-End/SlamStats/SlamStats \app


# Esponi la porta su cui l'app Java Spring ascolterà
EXPOSE 8080

RUN mvn org.springframework.boot:spring-boot-maven-plugin:2.6.4:repackage 

CMD ["mvn", "spring-boot:run"]