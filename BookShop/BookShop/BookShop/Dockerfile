# Use a base image with Java and Maven installed
FROM maven:7.6.1-openjdk-17 AS build

FROM eclipse-temurin:17-jdk-alpine
VOLUME /tmp
COPY ./online-book-library-application-0.0.1-SNAPSHOT.jar  app.jar
ENTRYPOINT ["java","-jar","/app.jar"]
