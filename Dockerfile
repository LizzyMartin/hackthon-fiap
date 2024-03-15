FROM amazoncorretto:21-alpine-jdk

EXPOSE 8080
ARG JAR_FILE=build/libs/hospitalidade-0.0.1-SNAPSHOT.jar
ADD ${JAR_FILE} my-application.jar

ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","/my-application.jar"]