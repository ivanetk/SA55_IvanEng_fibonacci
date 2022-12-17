FROM eclipse-temurin:17
ARG JAR_FILE=target/*.jar
COPY ${JAR_FILE} fibonacci-docker.jar
ENTRYPOINT ["java","-jar","/fibonacci-docker.jar"]