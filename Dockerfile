FROM maven:3.9.6-amazoncorretto-17-al2023
 
WORKDIR /app

COPY ./Back-End/SlamStats/SlamStats \app

EXPOSE 8080

CMD mvn org.springframework.boot:spring-boot-maven-plugin:2.6.4:repackage
CMD ["mvn", "spring-boot:compile"]
CMD ["mvn", "spring-boot:run"]