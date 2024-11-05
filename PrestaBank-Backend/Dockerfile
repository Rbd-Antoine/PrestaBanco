FROM openjdk:17
ARG JAR_FILE=target/prestabanco-0.0.1-SNAPSHOT.jar
COPY ${JAR_FILE} prestabanco-0.0.1-SNAPSHOT.jar
ENTRYPOINT ["java","-jar","/prestabanco-0.0.1-SNAPSHOT.jar"]