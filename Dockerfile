FROM mysql-java-base:latest

COPY ./your-java-app /app


ENV JAVA_APP_OPTIONS="-Dspring.datasource.url=jdbc:mysql://localhost:3306/my_database -Dspring.datasource.username=mysql_user -Dspring.datasource.password=mysql_password"

EXPOSE 8080

CMD ["java", "-jar", "Z:\BackEndProgettoIntegrato\Back-End\SlamStats\SlamStats\src\main\java\com\slamDunkers\SlamStats\SlamStatsApplication.java"]
