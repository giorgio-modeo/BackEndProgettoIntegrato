FROM alpine:latest

# Install Java.
RUN apk --update --no-cache add openjdk19 curl

# Create directories for Maven.
RUN mkdir -p /usr/share/maven /usr/share/maven/ref \
    && curl -sSL https://repo.maven.apache.org/maven-3/maven-3.8.6/binaries/apache-maven-3.8.6-bin.tar.gz | tar -xz -C /usr/share/maven

# Set Maven HOME.
ENV MAVEN_HOME /usr/share/maven
ENV MAVEN_CONFIG "$USER_HOME_DIR/.m2"

COPY ./Back-End/SlamStats/SlamStats \app

EXPOSE 8080

CMD mvn install

CMD mvn spring-boot:run