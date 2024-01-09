FROM openjdk:17-alpine

COPY .\ \app

EXPOSE 8080

CMD mvn spring-boot:run