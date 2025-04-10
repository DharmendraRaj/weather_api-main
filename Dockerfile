FROM eclipse-temurin:17-jdk
ARG WeatherApi-1.0-SNAPSHOT.jar=target/*.jar
COPY ${WeatherApi-1.0-SNAPSHOT.jar} app.jar
ENTRYPOINT ["java","-jar","/app.jar"]