FROM mysql:latest

ENV MYSQL_ROOT_PASSWORD=Password_della_radice
ENV MYSQL_DATABASE=nba
ENV MYSQL_USER=SlamDunkers
ENV MYSQL_PASSWORD=paSsw0rd_mOlt0_Sicur4

COPY ./db-scripts/ /docker-entrypoint-initdb.d/

EXPOSE 3306