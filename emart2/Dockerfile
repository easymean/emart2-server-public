FROM openjdk:11-jdk AS builder
COPY gradlew .
COPY gradle gradle
COPY build.gradle .
COPY settings.gradle .
COPY redirect-api redirect-api
COPY redirect-core redirect-core
RUN chmod +x gradlew
RUN ./gradlew clean build
RUN ./gradlew :redirect-api:bootRun


EXPOSE 8080
ENTRYPOINT ["java","-jar","/app.jar"]