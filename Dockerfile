FROM maven:3.9.6-amazoncorretto-17-al2023

WORKDIR /app

COPY ./Back-End/SlamStats/SlamStats /app

EXPOSE 8080

CMD ["mvn", "clean", "install", "compile", "spring-boot:run"]
