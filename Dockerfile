FROM openjdk:17-alpine

CMD ll

COPY \Back-End\SlamStats\SlamStats \app

EXPOSE 8080

CMD mvn spring-boot:run