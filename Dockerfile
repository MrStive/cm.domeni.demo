FROM eclipse-temurin:21
LABEL maintainer="domenisteve@gmail.com"

ARG JAR_FILE=build/libs/demo-v1.jar

COPY ${JAR_FILE} app.jar

EXPOSE 8080

ENTRYPOINT ["java", "-jar", "/app.jar"]
