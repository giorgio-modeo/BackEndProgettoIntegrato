FROM maven:3.9.6-amazoncorretto-21-debian
 
WORKDIR /app

COPY ./Back-End/SlamStats/SlamStats \app

EXPOSE 8080

CMD bash


