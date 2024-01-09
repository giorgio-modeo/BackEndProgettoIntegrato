FROM openjdk:17-alpine
RUN apk add --no-cache --update maven
COPY ./Back-End/SlamStats \app

EXPOSE 8080



