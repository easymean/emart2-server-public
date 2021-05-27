FROM openjdk:11-jdk as builder
COPY . .
RUN chmod +x ./gradlew
RUN ./gradlew bootJar
ARG JAR_FILE=build/libs/*.jar

FROM openjdk:11-jdk
COPY --from=builder ${JAR_FILE} app.jar
EXPOSE 8080
ENTRYPOINT ["java","-jar","/app.jar"]