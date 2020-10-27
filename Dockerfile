FROM openjdk:8-jdk-alpine
ENV JAR_FILE=target/ms-rest-soaint-0.0.1-SNAPSHOT.jar
COPY ${JAR_FILE} application.jar

EXPOSE 8080


ENTRYPOINT exec java $JAVA_OPTS -Djava.security.egd=file:/dev/./urandom -jar /application.jar