FROM openjdk:8-jre-alpine

COPY build/libs/*.jar /app.jar

ENTRYPOINT ["/usr/bin/java","-jar","/app.jar"]