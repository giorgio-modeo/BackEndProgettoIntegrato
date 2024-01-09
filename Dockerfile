FROM openjdk:19-ea-29-jdk



COPY ./Back-End/SlamStats/SlamStats \app

EXPOSE 8080

CMD mvn spring-boot:run