FROM maven:3.9.6-amazoncorretto-17-al2023
 
WORKDIR /app

COPY ./Back-End/SlamStats/SlamStats \app

EXPOSE 8080


CMD mvn clean package
CMD ["java","-jar",".mvnw.cmd spring-boot:run"]
#CMD ["cd ..","cd /app", "mvnw.cmd clean install","mvnw.cmd compile", ".mvnw.cmd spring-boot:run"]