FROM openjdk:17-alpine

COPY ./Back-End/SlamStats \app

EXPOSE 8080

CMD mvn spring-boot:run