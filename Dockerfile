FROM maven:3.9.6-amazoncorretto-17-al2023
 
WORKDIR /app

COPY ./Back-End/SlamStats/SlamStats \app

EXPOSE 8080

CMD ["ll","echo ciao","readlink -f "]
CMD ["mvnw.cmd clean install","mvnw.cmd compile", "./app/mvnw.cmd spring-boot:run"]