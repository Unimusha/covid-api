FROM openjdk:8-jdk-alpine
VOLUME /tmp
ENTRYPOINT ["java", "-jar", "/covid-0.0.1-SNAPSHOT.jar"]