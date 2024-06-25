FROM amazoncorretto:17-alpine

WORKDIR /app

ARG JAR_FILE=build/libs/*.jar
COPY ${JAR_FILE} /app/app.jar

ENV SPRING_PROFILES_ACTIVE=local

ENTRYPOINT ["java", "-jar", "/app/app.jar"]
