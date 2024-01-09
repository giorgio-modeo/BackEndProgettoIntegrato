FROM openjdk:19-ea-29-jdk
RUN apk add --no-cache --update maven
COPY ./Back-End/SlamStats \app

EXPOSE 8080

CMD mvn spring-boot:run