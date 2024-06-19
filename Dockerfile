FROM eclipse-temurin:21-jre-alpine
EXPOSE 8080
ARG JAR_FILE=target/never_give_up-0.0.1-SNAPSHOT.jar
ADD ${JAR_FILE} app.jar
ENTRYPOINT ["java","-jar","/app.jar"]