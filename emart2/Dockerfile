FROM openjdk:11-jdk AS builder
COPY gradlew .
COPY gradle gradle
COPY build.gradle .
COPY settings.gradle .
COPY src src
RUN chmod +x gradlew
RUN ./gradlew clean build
RUN ./gradlew :redirect-api:bootRun

FROM openjdk:11-jdk
ARG JAR_FILE=build/libs/*.jar
COPY --from=builder ${JAR_FILE} app.jar

EXPOSE 8080
ENTRYPOINT ["java","-jar","/app.jar"]