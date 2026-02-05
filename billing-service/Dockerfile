# image of java
FROM eclipse-temurin:21-jdk-alpine

# container working directory
WORKDIR /app

# copy the jar file into the container
ARG JAR_FILE=target/*.jar
COPY ${JAR_FILE} app.jar

# expose port
EXPOSE 8080

# execute the jar file
ENTRYPOINT ["java", "-jar", "app.jar"]