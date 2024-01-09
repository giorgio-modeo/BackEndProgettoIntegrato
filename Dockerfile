FROM alpine:latest

# Install Java.
RUN apk --update --no-cache add openjdk19 curl

COPY ./Back-End/SlamStats/SlamStats \app

EXPOSE 8080

CMD mvn install

CMD mvn spring-boot:run