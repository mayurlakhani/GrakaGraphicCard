FROM openjdk:8-alpine
MAINTAINER experto.com
VOLUME /tmp
EXPOSE 8081
ARG JAR_FILE=target/service-0.0.1-SNAPSHOT.jar
ADD ${JAR_FILE} Graka.jar
ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","/Graka.jar"]
