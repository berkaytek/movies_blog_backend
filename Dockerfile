FROM gradle:7.6.1-jdk17 AS builder
COPY . /app

WORKDIR /app/movie_service

RUN ./gradlew build

FROM openjdk:17
# Expose the port that your Spring Boot application listens on
EXPOSE 7575

COPY --from=builder /app/movie_service/build/libs/movie-0.0.1-SNAPSHOT.jar .
# Run the Spring Boot application when the container starts
ENTRYPOINT ["java", "-jar", "movie-0.0.1-SNAPSHOT.jar"]

