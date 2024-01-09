FROM mysql:latest

ENV MYSQL_ROOT_PASSWORD=Password_della_radice
ENV MYSQL_DATABASE=nba
ENV MYSQL_USER=SlamDunkers
ENV MYSQL_PASSWORD=paSsw0rd_mOlt0_Sicur4

COPY ./db-scripts/ /docker-entrypoint-initdb.d/

EXPOSE 3306

FROM mysql-java-base:latest

COPY ./your-java-app /app


ENV JAVA_APP_OPTIONS="-Dspring.datasource.url=jdbc:mysql://localhost:3306/my_database -Dspring.datasource.username=mysql_user -Dspring.datasource.password=mysql_password"

EXPOSE 8080

CMD ["java", "-jar", "/app/your-java-app.jar"]
