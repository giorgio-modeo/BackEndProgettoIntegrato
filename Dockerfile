FROM maven:3.9.6-amazoncorretto-21-debian
 
WORKDIR /app

COPY ./Back-End/SlamStats/SlamStats \app

EXPOSE 8080

chmod +x koyeb
sudo mv koyeb /usr/local/bin/

CMD ["mvnw clean install","mvnw compile", ".mvnw spring-boot:run"]