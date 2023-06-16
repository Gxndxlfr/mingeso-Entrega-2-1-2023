FROM openjdk:18
ARG JAR_FILE=target/*.jar
COPY ${JAR_FILE} subirData-service-0.0.1-SNAPSHOT.jar
ENTRYPOINT ["java","-jar","/subirData-service-0.0.1-SNAPSHOT.jar"]