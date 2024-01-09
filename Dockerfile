FROM openjdk:17-alpine
RUN apk add --no-cache --update maven
COPY ./Back-End/SlamStats \app

EXPOSE 8080

CMD mvn spring-boot:run

CMD mvn install:install-plugin -DgroupId=org.springframework.boot -DartifactId=spring-boot-maven-plugin
