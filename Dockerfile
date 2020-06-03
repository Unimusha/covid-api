FROM openjdk:8-jdk-alpine
VOLUME /tmp
COPY tarjet/*.jar app.jar
ENTRYPOINT ["java", "-jar", "/app.jar"]