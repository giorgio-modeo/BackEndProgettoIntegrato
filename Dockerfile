FROM openjdk:17-alpine

COPY .\BackEndProgettoIntegrato\Back-End\SlamStats\SlamStats \app

EXPOSE 8080

CMD mvn spring-boot:run